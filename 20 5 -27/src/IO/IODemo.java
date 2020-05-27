package IO;

import java.io.File;

public class IODemo {
    public static void main(String[] args) {
        File file = new File("g:");
        File[] files = file.listFiles();
        for (File f: files) {
            listAll(f);
        }
    }
    public static void listAll(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            if (files != null) {
                for (File f: file.listFiles()) {
                    listAll(f);
                }
            }
        }
        else{
            System.out.println(file);
        }
    }
}
