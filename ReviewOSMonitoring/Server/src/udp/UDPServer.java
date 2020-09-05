package udp;

import data.Storage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPServer {
    private static Thread worker;
    public static void startWork(){
        worker = new Thread(){
            @Override
            public void run() {
                UDPServer udpServer = new UDPServer();
                udpServer.work();  //收集数据
            }
        };
        worker.start();  //启动收集数据的工作线程
    }
    private void work() {
        byte[] bytes = new byte[1024];
        try (DatagramSocket socket = new DatagramSocket(8000)) {
            while (true) {
                DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
                //该方法会阻塞，直到有消息传过来
                socket.receive(packet);
                String message = new String(bytes, 0, bytes.length, "ASCII");
                //按照事先约定好的格式进行拆分
                String[] messages = message.split("\\$");
                String hostName = messages[0];
                long time = Long.parseLong(messages[1]);
                double percent = Double.parseDouble(messages[2]);
                Storage.put(hostName, time, percent);
                //打印收集的日志信息
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String data = simpleDateFormat.format(new Date(time));
                System.out.println(hostName + ": " + data + " " + percent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
