package IOStream;

import java.io.*;

public class IODemo {
    FileOutputStream fileOutputStream = null;
    FileInputStream fileInputStream = null;

    public void copyImage(){
        try {
            //0.打开文件，用构造方法来指定对象
            //也可以用一个File对象来指定
            //InputStream找不见这个文件会报错
            //OutputStream找不见这个文件会自动创建
            // 1. 读取玫瑰花文件.
            //    read() 版本是一次读一个字节. 读到的内容会放到返回值中.
            //    read(byte[]) 版本是一次读 N 个字节, N 取决于 byte[] 的长度, 会尽量尝试把数组填满.
            //                 byte[] 就相当于是用户指定的缓冲区, 返回值表示实际读到的字节数. 如果返回 -1 表示读取结束了
            //    read(byte[], int offset, int len) 版本是针对上一个版本的加强版本.
            //    此处的 buffer 都是用户指定的缓冲区, 而 FileInputStream 和 FileOutputStream 内部没有缓冲区.
            fileInputStream = new FileInputStream("G:\\test.png");
            fileOutputStream = new FileOutputStream("F:\\test2.png");
            int len = 0;
            byte[] buffer = new byte[1024];
            // 这样的循环读取就能保证把整个文件都读完.
            // 这个代码的含义是, 先调用 read, 把返回值写入 len 变量中.
            // 再拿 len 和 -1 进行比较.
            while((len=fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
                // 2. 把文件内容写入到另外一个文件中.
                // write 有三个版本
                // write(int b)  一次写一个字节.
                // write(byte[] buffer) 一次写 N 个字节. 把整个数组中的内容全写进去.
                // write(byte[] buffer, int offset, int len) 第二个版本的加强版.
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 读写完成之后, 一定要记得关闭文件.
                // 关闭顺序无所谓.
                // [注意!!!!!!] 这个代码虽然写了 close , 但是仍然存在潜在的问题.
                // close 可能会执行不到!!!!
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        IODemo ioDemo = new IODemo();
        ioDemo.copyImage();
    }
}
