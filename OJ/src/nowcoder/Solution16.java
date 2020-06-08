package nowcoder;

import java.util.Scanner;

/**
 * 最小公倍数
 */
public class Solution16 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = a*b;
        while(a%b != 0){
            int c = a%b;
            a = b;
            b = c;
        }
        int ret = n/b;
        System.out.println(ret);
    }
}
