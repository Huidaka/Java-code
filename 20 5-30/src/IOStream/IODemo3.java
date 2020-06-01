package IOStream;

import java.io.*;

/**
 * 带缓冲区的字节流复制文件
 */
public class IODemo3 {
    public void copyImage(){
        //0.打开文件
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("G:\\test.png"));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("F:\\test.png"))){
            int len = 0;
            byte[] buffer = new byte[1024];
            //1.打开图片文件
            while ((len = bufferedInputStream.read(buffer)) != -1){
                //把文件内容写入到另一个文件中
                bufferedOutputStream.write(buffer,0,len);
            }
        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IODemo3 ioDemo3 = new IODemo3();
        ioDemo3.copyImage();
    }
}
