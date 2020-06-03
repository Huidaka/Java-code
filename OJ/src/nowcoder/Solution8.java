package nowcoder;

import java.util.Scanner;

/**
 * 最长的数字子串
 */
public class Solution8 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer maxString = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)>='1' && str.charAt(i)<='9'){
                maxString = maxString.append(str.charAt(i));
            }
            else{
                maxString = maxString.append(' ');
            }
        }
        String str2 = new String(maxString);
        String[] strings = str2.split(" ");
        int maxLen = 0;
        for(String s: strings){
            if(s.length() > maxLen){
                maxLen = s.length();
            }
        }
        for(String s: strings){
            if(s.length() == maxLen){
                System.out.println(s);
            }
        }
    }
}
