package huidaka.tcpserver;

import huidaka.storage.ReportData;
import huidaka.storage.Storage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class Listener {
    public static Thread woker;
    public static final Map<String, List<Socket>> subscribers = new ConcurrentHashMap<>();

    public static void subscribe(Socket socket, String hostname){
        List<Socket> sockets = subscribers.computeIfAbsent(hostname,k -> new ArrayList<>());
        synchronized (sockets){
            sockets.add(socket);
        }
    }

    public static byte[] reportDataToByte(ReportData reportData) throws UnsupportedEncodingException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(reportData.time))));
        String message = String.format("%s %s %.2f%%\r\n",reportData.hostname,sd,reportData.percent);
        return message.getBytes("ASCII");
    }

    public static void pushMessage(String hostname, List<Socket> sockets, ReportData reportData){
        for (Socket socket : sockets) {
            try {
                socket.getOutputStream().write(reportDataToByte(reportData));
                socket.getOutputStream().flush();
            } catch (IOException e) {
                unsubscribe(hostname,socket);
            }
        }
    }

    private static void unsubscribe(String hostname, Socket socket) {
        List<Socket> sockets = subscribers.get(hostname);
        if(sockets == null){
            return;
        }
        synchronized (sockets) {
            sockets.remove(socket);
            if(sockets.size() == 0){
                subscribers.remove(hostname);
            }
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void work() throws InterruptedException {
        for(String hostname : subscribers.keySet()){
            ReportData reportData;
            try {
                reportData = Storage.getNewReportData(hostname);
            }catch (RuntimeException runtimeException){
                runtimeException.printStackTrace();
                System.out.println("队列为空");
                reportData = null;
            }
            if(reportData == null){
                continue;
            }

            List<Socket> sockets = subscribers.get(hostname);
            if(sockets == null){
                continue;
            }
            List<Socket> socketsCopy;
            synchronized (sockets) {
                socketsCopy = new ArrayList<>(sockets);
            }
            pushMessage(hostname,socketsCopy,reportData);
        }
        TimeUnit.SECONDS.sleep(1);
    }

    public static void startWoker(){
        woker = new Thread(){
            @Override
            public void run() {
                setName("发报员");
                while (true) {
                    try {
                        work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        woker.start();
    }
}
