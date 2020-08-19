package huidaka.tcpserver;

import javax.naming.ldap.SortKey;
import java.net.Socket;

public interface Command {
    void run(Socket socket, String[] args);
}
