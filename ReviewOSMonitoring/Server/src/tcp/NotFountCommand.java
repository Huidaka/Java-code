package tcp;

import java.io.IOException;
import java.net.Socket;

public class NotFountCommand implements Command{
    @Override
    public void run(Socket socket, String[] args) {
        //无法处理的命令直接关闭连接
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
