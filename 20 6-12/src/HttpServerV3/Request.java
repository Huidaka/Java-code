package HttpServerV3;

import java.io.*;
import java.util.HashMap;

public class Request {
    private String method = null;
    private String url = null;
    private String version = null;
    private HashMap<String,String> parameter = new HashMap<>();
    private HashMap<String,String> heads = new HashMap<>();
    private HashMap<String,String> cookie = new HashMap<>();
    private String body = null;

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

    public String getParatemer(String key) {
        return parameter.get(key);
    }

    public String getHeads(String key) {
        return heads.get(key);
    }

    public String getCookie(String key) {
        return cookie.get(key);
    }

    public StringBuilder getBody() {
        return body;
    }

    public static Request build(InputStream inputStream) {
        Request request = new Request();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            //1.解析首行
            String firstLine = bufferedReader.readLine();
            String[] firstToken = firstLine.split(" ");
            request.method = firstToken[0];
            request.url = firstToken[1];
            request.version = firstToken[2];
            //解析url中的参数
            int flag = request.url.indexOf("?");
            if (flag != -1) {
                String parameters = request.url.substring(flag + 1);
                parsePatamerter(parameters,request.parameter);
            }
            //解析head
            String line = "";
            while ((line = bufferedReader.readLine()) != null && line.length() != 0){
                String[] lineToken = line.split(": ");
                request.heads.put(lineToken[0],lineToken[1]);
            }
            //解析cookie
            String strCookie = null;
            if((strCookie = request.heads.get("Cookie")) != null){
                parsePatamerter(strCookie,request.cookie);
            }
            //解析body
            if(request.method.equalsIgnoreCase("post") || request.method.equalsIgnoreCase("put")){
                int len = Integer.parseInt(request.heads.get("Content-Type"));
                char[] buffer = new char[len];
                bufferedReader.read(buffer,0,len);
                request.body = new String(buffer);
                parsePatamerter(request.body,request.parameter);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return request;
    }

    private static void parsePatamerter(String strs, HashMap<String, String> outPut) {
        String[] stirngToken = strs.split("&");
        for(String s : stirngToken){
            String[] results = s.split("=");
            outPut.put(results[0],results[1]);
        }
    }
}
