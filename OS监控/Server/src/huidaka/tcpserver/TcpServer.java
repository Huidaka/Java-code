package huidaka.tcpserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer {
    public static void startWoker(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                TcpServer tcpServer = new TcpServer();
                tcpServer.start();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public void start(){
        CommandBuilder commandBuilder = new CommandBuilder();
        try (ServerSocket serverSocket = new ServerSocket(8000)){
            while (true) {
                Socket socket = serverSocket.accept();
                commandBuilder.buildAndRun(socket);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
