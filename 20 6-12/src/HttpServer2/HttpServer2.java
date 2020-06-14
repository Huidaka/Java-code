package HttpServer2;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer2 {
    private ServerSocket serverSocket = null;

    public HttpServer2(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true){
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });
        }
    }

    public void process(Socket cilentSocket){
        try {
            Request request = Request.bulid(cilentSocket.getInputStream());
            Response response = Response.bulid(cilentSocket.getOutputStream());
            if (request.getUrl().startsWith("/calc")){
                response.setStatus("200");
                response.setMessage("OK");
                response.setHeads("Content-Type","text/html; charset = utf-8");
                int a = Integer.parseInt(request.getParameter("a"));
                int b = Integer.parseInt(request.getParameter("b"));
                int sum  = a + b;
                response.setBody("<html>");
                response.setBody("a + b = " + sum);
                response.setBody("</html>");
            }
            else if(request.getUrl().equals("/200")){
                response.setStatus("200");
                response.setMessage("OK");
                response.setHeads("Content-Type","text/html; charset=utf-8");
                response.setBody("<html>");
                response.setBody("200 OK 哈哈哈");
                response.setBody("</html>");
            }
            else if(request.getUrl().equals("/cookie")){
                response.setStatus("200");
                response.setMessage("OK");
                String cookie = "sessionId=aaabbbccc";
                response.setHeads("Set-Cookie",cookie);
                response.setHeads("Content-Type","text/html; charset=UTF-8");
                response.setBody("<html>");
                response.setBody(("服务器给客户端设置 cookie 了, cookie 的内容为: " + cookie));
                response.setBody("</html>");
            }
            System.out.println(request.toString());
            response.flush();
            cilentSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServer2 httpServer2 = new HttpServer2(9090);
        httpServer2.start();
    }
}
