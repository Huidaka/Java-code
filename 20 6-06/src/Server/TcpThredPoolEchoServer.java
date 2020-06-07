package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpThredPoolEchoServer {
    ServerSocket serverSocket = null;

    public TcpThredPoolEchoServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while(true){
            Socket socket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    processConnect(socket);
                }
            });
        }
    }
     public void processConnect(Socket socket){
         System.out.println("客户端已连接：" + socket.getLocalSocketAddress());
         try(BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
             while (true){
                 String request = bufferedReader.readLine();
                 String response = process(request);
                 bufferedWriter.write(response+"\n");
                 bufferedWriter.flush();
                 String log = String.format("[%s] request:%s , response:%s",socket.getLocalSocketAddress(),request,response);
                 System.out.println(log);
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

     public String process(String request){
        return request;
     }

    public static void main(String[] args) throws IOException {
        TcpThredPoolEchoServer tcpThredPoolEchoServer  = new TcpThredPoolEchoServer(9090);
        tcpThredPoolEchoServer.start();
    }
}
