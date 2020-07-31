package nowcoder;

import java.util.Scanner;

/**
 * 字符串加解密
 */
public class Solution47 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String pStr = sc.nextLine();
            System.out.println(Encrypt(str));
            System.out.println(UnEncrypt(pStr));
        }
    }
    public static String Encrypt(String str){
        char[] res = new char[str.length()];
        for(int i = 0; i<str.length(); i++){
            char temp = str.charAt(i);
            if(temp >= 48 && temp <= 57){
                if(temp == '9'){
                    res[i] = '0';
                }
                else{
                    res[i] = (char)(temp+1);
                }
            }
            if(temp >= 65 && temp <= 90){
                if(temp == 'Z'){
                    res[i] = 'a';
                }
                else{
                    res[i] = (char)(temp+32+1);
                }
            }
            if(temp >= 97 && temp <= 122){
                if(temp == 'z'){
                    res[i] = 'A';
                }
                else{
                    res[i] = (char)(temp-32+1);
                }
            }
        }
        return String.valueOf(res);
    }
    public static String UnEncrypt(String str){
        char[] res = new char[str.length()];
        for(int i = 0; i<str.length(); i++){
            char temp = str.charAt(i);
            if(temp >= 48 && temp <= 57){
                if(temp == '0'){
                    res[i] = '9';
                }
                else{
                    res[i] = (char)(temp-1);
                }
            }
            if(temp >= 65 && temp <= 90){
                if(temp == 'A'){
                    res[i] = 'z';
                }
                else{
                    res[i] = (char)(temp+32-1);
                }
            }
            if(temp >= 97 && temp <= 122){
                if(temp == 'a'){
                    res[i] = 'Z';
                }
                else{
                    res[i] = (char)(temp-32-1);
                }
            }
        }
        return String.valueOf(res);
    }
}
