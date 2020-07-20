package nowcoder;
import java.util.Scanner;

/**
 * 说反话
 */
public class Solution34 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str.equals("")){
            System.out.print("");
        }
        String[] strs = str.split(" ");
        int len = strs.length;
        for(int i = 0 ,j = len-1; i<len/2; i++,j--){
            String str1 = strs[i];
            String str2 = strs[j];
            String temp = str1;
            strs[i] = str2;
            strs[j] = temp;
        }
        for(int i=0; i<len; i++){
            System.out.print(strs[i]+" ");
        }
    }
}