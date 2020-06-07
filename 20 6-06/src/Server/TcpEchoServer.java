package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpEchoServer {
    ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动：");
        while(true){
            Socket cilentsoket = serverSocket.accept();
            func(cilentsoket);
        }
    }

    public void func(Socket cilentsoket) throws IOException {
        System.out.println("客户端已连接："+cilentsoket.getInetAddress());
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cilentsoket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(cilentsoket.getOutputStream()))){
            while (true) {
                String request = bufferedReader.readLine();
                String response  = process(request);
                bufferedWriter.write(response+"\n");
                bufferedWriter.flush();
                String log = String.format("[%s] request:%s response:%s",cilentsoket.getLocalSocketAddress(),request,response);
                System.out.println(log);
            }
        } catch (IOException e){

        }
    }

    public String process (String request){
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer tcpEchoServer = new TcpEchoServer(9090);
        tcpEchoServer.start();
    }
}
