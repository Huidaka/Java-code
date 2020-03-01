package cn.Huidaka;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class StringOperation {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        String[] strs = str.split(" ");
//        for (int i = 0; i < strs.length; i++) {
//            System.out.print(strs[i]);
//        }
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String str = scanner.nextLine();
        System.out.println(func(str,k));
    }

    public static String reverse(String str,int left,int right) {
        char[] chars = str.toCharArray();
        while(left<right){
            char temp = chars[right];
            chars[right] = chars[left];
            chars[left] = temp;
            left++;
            right--;
        }
        String str2 = new String(chars);
        return str2;
    }

    public static String  func(String str ,int k){
        if(k<=0 || k>=str.length()){
            return str;
        }
        String str1 = reverse(str,0,k-1);
        String str2 = reverse(str1,k,str1.length()-1);
        String str3 = reverse(str2,0,str2.length()-1);
        return str3;
    }
}
