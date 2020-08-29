package file;

import java.io.*;

/**
 * 字节流复制图片
 */
public class IODemo {
    public static void main(String[] args) {
        fileInputStreamCopy();
        bufferFileInputStreamCopy();
    }

    public static void fileInputStreamCopy(){
        long timestart = System.currentTimeMillis();
        try(FileInputStream fileInputStream = new FileInputStream("G:\\QQ文档\\test.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("G:\\test1.txt")
        ) {
            while (fileInputStream.read() != -1){
                fileOutputStream.write(1);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        long timeend = System.currentTimeMillis();
        System.out.println("无缓冲区时间："+(timeend-timestart));
    }

    public static void bufferFileInputStreamCopy(){
        long timestart = System.currentTimeMillis();
        try(BufferedInputStream inputStream = new BufferedInputStream(
                new FileInputStream("G:\\QQ文档\\开发环境配置.pdf"));
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream("G:\\test2.pdf"))
        ) {
            while (inputStream.read() != -1){
                outputStream.write(1);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        long timeend = System.currentTimeMillis();
        System.out.println("有缓冲区时间："+(timeend-timestart));
    }
}
