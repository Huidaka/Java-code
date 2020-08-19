package huidaka.tcpserver;

import java.io.IOException;
import java.net.Socket;

public class GetCommand implements Command {

    @Override
    public void run(Socket socket, String[] args) {
        if(args.length == 0){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Listener.subscribe(socket,args[0]);
    }
}
