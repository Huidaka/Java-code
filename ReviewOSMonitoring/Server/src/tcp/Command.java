package tcp;

import java.net.Socket;

//命令接口
public interface Command {
    void run(Socket socket,String[] args);
}
