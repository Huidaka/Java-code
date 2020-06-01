package nowcoder;

import java.util.Scanner;

/**
 * 回文串的几种插法
 */
public class Solution5{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int flag = 0;
            String strA = sc.nextLine();
            String strB = sc.nextLine();
            if(strA == null || strB == null){
                System.out.println(0);
            }
            else{
                int len = strA.length();
                if(isHuiwen(strA+strB)) flag++;
                if(isHuiwen(strB+strA)) flag++;
                for(int i = 1; i < len; i++){
                    String str = strA.substring(0,i) + strB + strA.substring(i,len);
                    if(isHuiwen(str)){
                        flag++;
                    }
                }
                System.out.println(flag);
            }
        }
    }

    private static boolean isHuiwen(String str){
        int i=0;
        int j=str.length()-1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
