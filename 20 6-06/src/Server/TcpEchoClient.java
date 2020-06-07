package Server;

import sun.plugin2.message.JavaScriptCallMessage;

import java.io.*;
import java.net.Socket;

import java.util.Scanner;

public class TcpEchoClient {
    Socket socket = null;
    String serverIp = null;
    int serverPort = 0;

    public TcpEchoClient(String serverIp, int serverPort) throws IOException {
        this.socket = new Socket(serverIp,serverPort);
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
            while (true) {
                System.out.print("->");
                String request = scanner.nextLine();
                if (request == null) {
                    System.out.println("客户端发送数据结束");
                    break;
                }
                bufferedWriter.write(request + "\n");
                bufferedWriter.flush();
                String response = bufferedReader.readLine();
                if(response == null){
                    System.out.println("服务器断开连接");
                    break;
                }
                System.out.println("request:" + request + " response:" + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1",9090);
        tcpEchoClient.start();
    }
}
