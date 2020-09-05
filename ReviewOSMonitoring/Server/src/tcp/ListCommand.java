package tcp;

import data.Storage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ListCommand implements Command{
    @Override
    public void run(Socket socket, String[] args) {
        try {
            //把存放的主机信息列表都发给Client
            for (String hostName : Storage.map.keySet()) {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bufferedWriter.write(hostName + "\r\n");
                //刷新缓冲区
                bufferedWriter.flush();
            }
            //关闭连接
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
