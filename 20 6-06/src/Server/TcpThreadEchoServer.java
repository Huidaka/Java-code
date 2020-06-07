package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class TcpThreadEchoServer {
    ServerSocket serverSocket = null;

    public TcpThreadEchoServer(int Port) throws IOException {
        this.serverSocket = new ServerSocket(Port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            Socket socket = serverSocket.accept();
            Thread t = new Thread() {
                @Override
                public void run() {
                    processConect(socket);
                }
            };
            t.start();
        }
    }

    public void processConect(Socket socket) {
        System.out.println("客户端已连接："+socket.getInetAddress());
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            while (true) {
                String request = bufferedReader.readLine();
                String response = process(request);
                bufferedWriter.write(response + "\n");
                bufferedWriter.flush();
                String log = String.format("[%s]  request:%s , response:%s", socket.getLocalSocketAddress(), request, response);
                System.out.println(log);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String process(String request) {
        HashMap<String,String> map = new HashMap<>();
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpThreadEchoServer tcpThreadEchoServer = new TcpThreadEchoServer(9090);
        tcpThreadEchoServer.start();
    }
}
