package huidaka;

import huidaka.tcpserver.Listener;
import huidaka.udpserver.UDPServer;
import huidaka.tcpserver.TcpServer;

public class Server {
    public static void main(String[] args) {
        UDPServer.startWoker();
        TcpServer.startWoker();
        Listener.startWoker();
    }
}
