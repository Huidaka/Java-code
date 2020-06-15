package HttpServerV3;

import javax.print.attribute.standard.PresentationDirection;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Response {
    private String version = null;
    private String status = null;
    private String message = null;
    private HashMap<String,String> head = new HashMap<>();
    private StringBuilder body = null;
    private OutputStream outputStream = null;

    public static Response bulid(OutputStream outputStream){
        Response response = new Response();
        response.outputStream = outputStream;
        return response;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHead(String key, String values) {
        head.put(key,values);
    }

    public void setBody(String body1) {
        this.body.append(body1);
    }

    public void flush(){
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        try {
            bufferedWriter.write(version + " " + status + " " + message + "\n");
            bufferedWriter.write("Content-Length: " + body.toString().getBytes().length);
            for(Map.Entry<String,String> entry : this.head.entrySet()){
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
