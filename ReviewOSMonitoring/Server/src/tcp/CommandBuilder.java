package tcp;

import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

//将Client发过来的数据生成相应命令
public class CommandBuilder {
    public void buildAndRun(Socket socket){
        try {
            Command command;
            // 按行读取 client 发送的命令
            // 目前支持两种命令: list / get
            Scanner scanner = new Scanner(socket.getInputStream(),"utf-8");
            String string = scanner.nextLine();
            String[] group = string.split(" ");
            String commandName = group[0];
            String[] args = Arrays.copyOfRange(group,1,group.length);
            if(commandName.equalsIgnoreCase("list")){
                //list命令，查看所有主机列表
                command = new ListCommand();
            }
            else if(commandName.equalsIgnoreCase("get")){
                //get命令，查看这个主机的CPU信息
                command = new GetCommand();
            }
            else {
                //如果是其他命令，就直接关闭连接
                command = new NotFountCommand();
            }
            //根据创建的实现接口类的对应实例，执行相应的命令
            command.run(socket,args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
