package nowcoder;

import java.util.Scanner;

/**
 * 将int数字逆置字符串输出
 */
public class Solution21 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = String.valueOf(n);
        StringBuffer buffer = new StringBuffer(str);
        StringBuffer nstr = buffer.reverse();
        System.out.println(nstr);
    }
}
