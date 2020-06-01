package IOStream;

/**
 * 字符流操作复制图片
 */

import java.io.*;

public class IODemo4 {
    public void copyImage(){
        try(FileReader fileReader = new FileReader("G:\\test.png");
            FileWriter fileWriter = new FileWriter("G:\\test3.png")){
            int len = 0;
            char[] chars = new char[1024];
            while((len = fileReader.read(chars)) != -1){
                fileWriter.write(chars,0,len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IODemo4 ioDemo4 = new IODemo4();
        ioDemo4.copyImage();
    }
}
