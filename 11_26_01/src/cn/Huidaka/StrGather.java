package cn.Huidaka;

import java.awt.*;
import java.util.Scanner;

public class StrGather {
    public static int count = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while(sc.hasNext()) {
            count = 1;
            str = sc.nextLine();
                char[] s = str.toCharArray();
                if (s.length > 100) {
                    return;
                }
                int i = 0;
                int j = 1;
                System.out.print(s[0]);
                for (i = 1; i < s.length; i++) {
                    count = i;
                    if (judgeRetition(s[i], s)) {
                        continue;
                    } else {
                        System.out.print(s[i]);
                    }
                }
                System.out.println("");
            }
    }
    public static boolean judgeRetition(char a,char[] s){
        for(int i=0; i<count; i++){
            if(a == s[i]){
                return true;
            }
        }
        return false;
    }
}
