package HttpServer2;

import javafx.scene.control.TableRow;
import sun.plugin2.message.BestJREAvailableMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

//获取并分析请求
public class Request {
    private String method = null;
    private String url = null;
    private String version = null;
    private HashMap<String,String> heads = new HashMap<>();
    private HashMap<String,String> parameter = new HashMap<>();

    @Override
    public String toString() {
        return
                method + " " + url + " " + version + "\n" +
                heads + "\n" +
                parameter;
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public String getVersion() {
        return version;
    }

    public String getHeads(String key) {
        return heads.get(key);
    }

    public String getParameter(String key) {
        return parameter.get(key);
    }

    public static Request bulid(InputStream inputStream){
        Request request = new Request();
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //分析首行
            String firstLine = bufferedReader.readLine();
            String[] firstToken = firstLine.split(" ");
            request.method = firstToken[0];
            request.url = firstToken[1];
            request.version = firstToken[2];
            //分析url中的参数
            int falg = request.url.indexOf("?");
            if (falg != -1) {
                String str = request.url.substring(falg+1);
                String[] parameters =  str.split("&");
                for(String s : parameters){
                    String[] result = s.split("=");
                    request.parameter.put(result[0],result[1]);
                }
            }
            //分析head头
            String line = "";
            while((line = bufferedReader.readLine()) != null && line.length() != 0){
                String[] lineToken = line.split(": ");
                request.heads.put(lineToken[0],lineToken[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return request;
    }
}
