package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void startWork(){
        //Tcp工作线程
        Runnable runnable  = new Runnable() {
            @Override
            public void run() {
                work();
            }
        };
        Thread thread = new Thread(runnable);
        //启动线程
        thread.start();
    }

    private static void work(){
        CommandBuilder commandBuilder = new CommandBuilder();
        try(ServerSocket serverSocket = new ServerSocket(8001)){
            while (true) {
                //建立TCP连接
                Socket socket = serverSocket.accept();
                //分析Client发送的数据，并生成相应的命令
                commandBuilder.buildAndRun(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
