package file;

import java.io.*;

/**
 * 字符流转字节流
 */
public class IODemo6 {
    public static void main(String[] args) {
        //定义字节流输出对象
        OutputStream outputStream = System.out;
        try(BufferedReader reader = new BufferedReader(new FileReader("G:\\test.txt"));
            //通过OutputStreamWriter将字符流转换为字节流
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            String line = null;
            while ((line = reader.readLine()) != null){
                //输出到控制台
                writer.write(line);
                //换行
                writer.write("\r\n");
                //刷新缓冲区
                writer.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
