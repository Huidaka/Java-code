package Huidaka;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


 public class DeleteRepetitionChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        List<String> list = delRepetitionchar(str1,str2);
        for (String s:list) {
            System.out.print(s);
        }

    }
    /**
     * 删除在字符串2中出现的字符1中的字符
     * @param str1
     * @param str2
     */
    public static List<String> delRepetitionchar(String str1, String str2){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            if(!str2.contains(str1.charAt(i)+"")){
                list.add(str1.charAt(i)+"");
            }
        }
        return list;
    }

 }
