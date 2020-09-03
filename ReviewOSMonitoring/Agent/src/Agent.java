import com.sun.management.OperatingSystemMXBean;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

//收集数据端
public class Agent{
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("请按照规定传入运行时参数");
            return;
        }
        //获取运行时传入的参数
        String hostName = args[0];
        long interval = Long.parseLong(args[1]);
        String serverHost = args[2];
        int port = Integer.parseInt(args[3]);
        //利用系统的Soket采用UDP协议进行发送
        try (DatagramSocket socket = new DatagramSocket();) {    //初始化发送数据包的skoet
            while (true) {
                //记录当前系统时间
                long time = System.currentTimeMillis();
                //获取Cpu使用率
                OperatingSystemMXBean platformMXBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
                double percent = platformMXBean.getSystemCpuLoad();
                //封装消息
                String message = String.format("%s$%d$%f", hostName, time, percent);
                byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
                DatagramPacket datagramPacket = new DatagramPacket(
                        bytes, 0, bytes.length, InetAddress.getByName(serverHost), port);
                //发送数据
                socket.send(datagramPacket);
                System.out.println(message);
                //间隔秒数
                TimeUnit.SECONDS.sleep(interval);
            }
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
