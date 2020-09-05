import tcp.Listener;
import tcp.TCPServer;
import udp.UDPServer;

public class Server {
    public static void main(String[] args) {
        UDPServer.startWork();
        TCPServer.startWork();
        Listener.startWork();
    }
}
