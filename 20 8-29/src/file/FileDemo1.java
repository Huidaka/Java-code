package file;

import java.io.File;

/**
 * 递归打印文件目录列表
 */
public class FileDemo1 {
    private void listOut(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
                for (File file1 : files) {
                    listOut(file1);
                    System.out.println(file1);
                }
        }
        else{
            System.out.println(file);
        }
    }

    public static void main(String[] args) {
        File file = new File("src");
        FileDemo1 testFile = new FileDemo1();
        testFile.listOut(file);
    }
}
