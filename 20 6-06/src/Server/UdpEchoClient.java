package Server;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    //客户端需要知道服务器的ip和端口
    DatagramSocket socket = null;
    String ServerIp = null;
    int Serverport = 0;

    public UdpEchoClient(String serverIp, int serverport) throws SocketException {
        this.socket = new DatagramSocket();
        ServerIp = serverIp;
        Serverport = serverport;
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("->");
            //获取请求
            String request = scanner.nextLine();
            if(request.equals("exit")){
                System.out.println("goodbye");
                break;
            }
            //    把这个字符串构造成一个请求, 发送给服务器.
            //    客户端 send 的这个请求对象, 内部的数据就和服务器接受到的请求对象内部数据是一致的.
            //    这个数据报中的内容就是通过网络通信的方式传输过去的. (各层协议一直封装分用)
            DatagramPacket requsetPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                     InetAddress.getByName(ServerIp),Serverport);
            //发送请求
            socket.send(requsetPacket);
            //读取响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(),0,responsePacket.getLength()).trim();
            //打印日志
            String log = String.format("req: %s; resp: %s", request, response);
            System.out.println(log);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1",9090);
        udpEchoClient.start();
    }
}
