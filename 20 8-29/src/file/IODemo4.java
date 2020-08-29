package file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IODemo4 {
    public void copyImage(){
        try(FileReader fileReader = new FileReader("G:\\test.txt");
            FileWriter fileWriter = new FileWriter("G:\\test3.txt")){
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