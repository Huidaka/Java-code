package nowcoder;

import java.util.Scanner;

/**
 * 斐波那契数列
 */
public class Solution22 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0;
        int b = 1;
        int fib = a + b;
        if(n == 0){
            System.out.println(0);
        }
        while(true){
            if(fib > n){
                System.out.println(Math.min((fib - n), (b - n)));
                return;
            }
            if(fib == n){
                System.out.println(0);
                return;
            }
            a = b;
            b = fib;
            fib = a + b;
        }
    }
}
