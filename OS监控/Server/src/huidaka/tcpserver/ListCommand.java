package huidaka.tcpserver;

import huidaka.storage.Storage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.List;

public class ListCommand implements Command {

    @Override
    public void run(Socket socket, String[] args) {
        try {
            for (String hostname : Storage.map.keySet()) {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bufferedWriter.write(hostname + "\r\n");
                bufferedWriter.flush();
            }
            socket.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}