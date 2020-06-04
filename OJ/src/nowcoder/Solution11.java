package nowcoder;

import java.util.Scanner;

/**
 * 替换字符串1中在字符2中出现的字符
 */
public class Solution11 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        for(int i = 0; i < str2.length(); i++){
            str1 = str1.replaceAll(String.valueOf(str2.charAt(i)),"");
        }
        System.out.println(str1);
    }
}
