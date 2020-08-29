package file;

import java.io.*;

public class IODemo5 {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("G:\\QQ文档\\test.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("G:\\test.txt"))){
            String content = "";
            while ((content=reader.readLine()) != null){
                writer.write(content + "\r\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
