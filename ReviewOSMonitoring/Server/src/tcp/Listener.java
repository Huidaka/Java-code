package tcp;

import data.ReportData;
import data.Storage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class Listener {
    //订阅表：都有谁订阅哪个主机的信息
    public static ConcurrentHashMap<String, List<Socket>> subscribers = new ConcurrentHashMap<>();

    //启动推送数据线程
    public static void startWork(){
        Listener listener = new Listener();
        try {
            listener.work();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //添加订阅
    public  void subscribe(Socket socket,String hostName){
        List<Socket> sockets = subscribers.computeIfAbsent(hostName,k->new ArrayList<>());
        synchronized (sockets) {
            sockets.add(socket);
        }
    }
    //工作线程：负责给Client推送数据
    private  void work() throws InterruptedException {
        while (true) {
            for(String hostName : subscribers.keySet()){
                ReportData reportData;
                try {
                    reportData = Storage.getNewReportData(hostName);
                }catch (RuntimeException runtimeException){
                    runtimeException.printStackTrace();
                    System.out.println("队列为空");
                    reportData = null;
                }
                //返回值为null，说明没有这个主机数据，直接跳过即可
                if(reportData == null){
                    continue;
                }
                List<Socket> sokets = subscribers.get(hostName);
                //返回值为null，说明没有连接需要这个主机的信息，跳过即可
                if(sokets == null){
                    continue;
                }
                //复制一份订阅信息，因为这个sockets一直再添加删除元素，我们为了线程安全会给他加锁，这样就会造成线程阻塞
                //从而影响另一个推送数据的工作效率，所以我们可以拷贝一份这个表，交给另一个推送线程就可以了
                List<Socket> socketCopy;
                synchronized (sokets) {
                    socketCopy = new ArrayList<>(sokets);
                }
                //推送数据
                pushMessage(socketCopy,hostName,reportData);
            }
            //每隔一秒推送一次数据
            TimeUnit.SECONDS.sleep(1);
        }
    }
    //推送数据具体工作
    private  void pushMessage(List<Socket> socketCopy,String hostName,ReportData reportData) {
        BufferedWriter bufferedWriter;
        for(Socket socket : socketCopy){
            try {
                //因为发送的都是字符数据，所以这里选用字符流进行发送
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                //获取格式化数据
                String message =  reportDataToByte(reportData);
                bufferedWriter.write(message);
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
                //一待出现异常，就直接关闭这个连接
                unSubscribers(hostName,socket);
            }
        }
    }
    //从订阅表删除这个连接的订阅 ，并关闭
    public void unSubscribers(String hostName, Socket socket){
        //删除订阅的连接，需要删除原链表的socket，不能删除复制过来的sockets
        List<Socket> sockets = subscribers.get(hostName);
        if(sockets == null){
            return;
        }
        synchronized (sockets) {
            sockets.remove(socket);
            if(sockets.size() == 0){
                //如果一个主机没有Client订阅它的信息了，就把他从订阅表中删除
                subscribers.remove(hostName);
            }
        }
        try {
            //关闭这个连接
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //将需要推送的数据取出并进行格式化
    public String reportDataToByte(ReportData data){
        //将时间戳转换成格式化日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(new Date(data.time));
        String message = String.format("%s %s %.2f%%\r\n",data.hostName,time,data.percent*100);
        return message;
    }
}
