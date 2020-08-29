package file;

import java.io.File;
import java.io.IOException;

/**
 * 创建文件，如果文件父目录不存在就先创建文件父目录
 */
public class FileDemo2 {
    public static void main(String[] args) {
        String path = "G:\\001\\002\\003\\";
        String dirName = "test.txt";
        String pathName = path + dirName;
        File file = new File(pathName);
        File pfile = file.getParentFile();
        if(!pfile.exists()){
            pfile.mkdirs();
        }
        try {
            file.createNewFile();
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
