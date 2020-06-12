import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 手动实现HttpServer服务器
 */
public class HttpServer {
    public ServerSocket socket = null;

    public HttpServer(int port) throws IOException {
        this.socket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动：");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true){
            Socket clientsoket = socket.accept();
            executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        process(clientsoket);
                    }
            });
        }
    }

    public void process(Socket clientsoket) {
        System.out.printf("[%s]\n",clientsoket.getLocalSocketAddress());
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientsoket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientsoket.getOutputStream()))) {
            //读取首行内容
            String firstLine = bufferedReader.readLine();
            //分析首行内容
            String[] firstLineTokens = firstLine.split(" ");
            String mothod = firstLineTokens[0];
            String url = firstLineTokens[1];
            String version = firstLineTokens[2];
            HashMap<String,String> map = new HashMap<>();
            String line = "";
            //读取head
            while ((line = bufferedReader.readLine()) != null && line.length() != 0){
                String[] headTokens = line.split(": ");
                map.put(headTokens[0],headTokens[1]);
            }
            //打印首行内容
            System.out.println(mothod + " " + url + " " + version);
            //打印head头
            for(Map.Entry<String,String> entry : map.entrySet()){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            // 2. 构造响应, 按理说是要根据不同的请求, 来生成不同的响应的.
            //    此处为了简单, 先无脑生成一个 helloworld 的网页.
            String body = "<html><div> hello world </div></html>";
            bufferedWriter.write("HTTP/1.0 200 OK\n");
            bufferedWriter.write("Content-Length: " + body.getBytes().length + "\n");
            bufferedWriter.write("Conten-Type: text/html\n");
            bufferedWriter.write("\n");
            bufferedWriter.write(body);
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                clientsoket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = new HttpServer(9090);
        httpServer.start();
    }
}
