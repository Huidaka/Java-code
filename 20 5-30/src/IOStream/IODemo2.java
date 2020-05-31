package IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo2 {

    public void copyImage(){
        try(FileInputStream fileInputStream = new FileInputStream("G:\\test.png");
            FileOutputStream fileOutputStream = new FileOutputStream("F:\\test.png")){
            int len = 0;
            byte[] buffer = new byte[1024];
            while((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        IODemo2 ioDemo = new IODemo2();
        ioDemo.copyImage();
    }
}
