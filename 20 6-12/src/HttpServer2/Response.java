package HttpServer2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Response {
    private String version = "HTTP/1.1";
    private String status = null;
    private String message = null;
    private HashMap<String,String> heads = new HashMap<>();
    private StringBuilder body = new StringBuilder();
    private OutputStream outputStream = null;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHeads(String key,String values) {
        heads.put(key,values);
    }

    public void setBody(String str) {
        body.append(str);
    }

    public static Response bulid(OutputStream outputStream){
        Response response = new Response();
        response.outputStream = outputStream;
        return response;
    }

    public void flush(){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write(version + " ");
            bufferedWriter.write(status + " ");
            bufferedWriter.write(message + "\n");
            bufferedWriter.write("Content-Length: " + body.toString().getBytes().length + "\n");
            for(Map.Entry<String,String> entry : this.heads.entrySet()){
                bufferedWriter.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            bufferedWriter.write("\n");
            bufferedWriter.write(body.toString());
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
