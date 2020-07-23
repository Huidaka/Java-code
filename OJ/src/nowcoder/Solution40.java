package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 查看键盘的哪个键坏掉了
 */
public class Solution40 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String standard = sc.nextLine().toUpperCase();
        String temp = sc.nextLine().toUpperCase();
        for(int i = 0; i<temp.length(); i++){
            char c = temp.charAt(i);
            standard = standard.replaceAll(String.valueOf(c),"");
        }
        List<Character> list = new ArrayList<>();
        for (int i=0; i<standard.length(); i++){
            char c = standard.charAt(i);
            if(!list.contains(c)){
                list.add(c);
            }
        }
        for(Character c : list){
            System.out.print(c);
        }
    }
}
