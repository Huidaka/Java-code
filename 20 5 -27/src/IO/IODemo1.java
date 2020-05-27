package IO;

import java.io.File;
import java.io.IOException;

public class IODemo1 {
    public static void main(String[] args) throws IOException {
        //获取文件对象
        File file = new File("G:/test.txt");
        if(file.exists()){
            file.delete(); //删除文件
            System.out.println("删除文件");
        }
        else {
            file.createNewFile(); //新建文件
            System.out.println("新建文件");
        }

        //获取文件目录
        File file2 = new File("G:\\aaa\\bbb\\ccc\\dddd\\dddd.txt");

        File pfile = file.getParentFile();
        if(!pfile.exists()){
            pfile.mkdirs();
            System.out.println("创建父目录");
        }
        if(!file2.exists()){
            file2.createNewFile();
            System.out.println("创建文件");
        }
    }
}
