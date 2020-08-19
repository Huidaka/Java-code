package huidaka.udpserver;

import huidaka.storage.Storage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class UDPServer {
    private static Thread woker;

    public static void startWoker() {
        woker = new Thread() {
            @Override
            public void run() {
                UDPServer udpServer = new UDPServer();
                udpServer.start();
            }
        };
        woker.start();
    }

    public void start(){
        byte[] buffer = new byte[1024];
        try(DatagramSocket datagramSocket = new DatagramSocket(8000)){
            while (true) {
                Arrays.fill(buffer,(byte)0);
                DatagramPacket recivePacket = new DatagramPacket(buffer, 0, buffer.length);
                //该方法会进行阻塞，知道有消息传过来
                datagramSocket.receive(recivePacket);
                String message = new String(buffer,0,buffer.length,"ASCII");
                String[] group = message.split("\\$");
                String hostname = group[0];
                long time = Long.parseLong(group[1]);
                double percent = Double.parseDouble(group[2]);
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String sd = sdf.format(new Date(Long.parseLong(String.valueOf(time))));
                System.out.println("收到来自 " + hostname + " 上报的数据");
                String sout = String.format("时间：%s cpu使用率：%.2f%%",sd,percent*100);
                System.out.println(sout);
                Storage.put(hostname, time, percent*100);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
