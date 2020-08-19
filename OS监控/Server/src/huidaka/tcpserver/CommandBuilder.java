package huidaka.tcpserver;

import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class CommandBuilder {
    public void buildAndRun(Socket socket){
        try {
            Scanner scanner = new Scanner(socket.getInputStream(),"utf-8");
            if(!scanner.hasNextLine()){
                return;
            }
            String line = scanner.nextLine();
            String[] group = line.split(" ");
            String commandName = group[0];
            String[] args = Arrays.copyOfRange(group,1,group.length);
            Command command;
            if(commandName.equals("list")){
                command = new ListCommand();
            }
            else if(commandName.equals("get")){
                command = new GetCommand();
            }
            else{
                command = new NotFoundCommand();
            }
            command.run(socket,args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
