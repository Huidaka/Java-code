package huidaka.tcpserver;

import java.io.IOException;
import java.net.Socket;

public class NotFoundCommand implements Command {
    @Override
    public void run(Socket socket, String[] args) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
