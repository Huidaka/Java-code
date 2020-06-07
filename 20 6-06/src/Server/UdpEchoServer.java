package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        this.socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动：");
        while(true){
            //获取并分析请求
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            //用trim来去除多余的空格
            String requset = new String(requestPacket.getData(),0,requestPacket.getLength()).trim();
            //根据请求计算响应
            String response = process(requset);
            //返回响应
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,requestPacket.getSocketAddress());
            socket.send(responsePacket);
            //打印日志
            String log = String.format("[%s] ; request: %s response: %s",
                    requestPacket.getSocketAddress().toString(),requset,response);
            System.out.println(log);
        }
    }

    public String process(String request){
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);
        udpEchoServer.start();
    }
}
