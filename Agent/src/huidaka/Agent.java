package huidaka;

import com.sun.management.OperatingSystemMXBean;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class Agent {
    public static void main(String[] args) throws InterruptedException {
        if(args.length < 4 ){
            System.out.println("请按照运行时参数传入数据");
            return;
        }
        //获取运行时参数
        String hostname = args[0];
        int interval = Integer.parseInt(args[1]);
        String serverHost = args[2];
        int port = Integer.parseInt(args[3]);
        OperatingSystemMXBean platformMXBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        while (true) {
            //获取cpu的实时使用率
            long time = System.currentTimeMillis()/1000;//以秒为单位
            double percent = platformMXBean.getSystemCpuLoad();
            //封装消息
            String message = String.format("%s$%d$%.4f",hostname,time,percent);
            System.out.println(message);
            //利用系统的soket采用UDP协议进行发送
            try (DatagramSocket socket = new DatagramSocket()){
                //初始化发送数据包的skoet
                byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
                DatagramPacket datagramPacket = new DatagramPacket(
                        bytes,0,bytes.length, InetAddress.getByName(serverHost),port
                );
                socket.send(datagramPacket);
                //间隔的秒数
                TimeUnit.SECONDS.sleep(interval);
            } catch (SocketException | UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
