package cn.Huidaka;
import java.util.*;
//非递归求斐波那契数
//public class Fibonacci {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n;
//        n = sc.nextInt();
//        System.out.println(fibonacci(n));
//    }
//    public static int fibonacci(int n){
//        int i;
//        int c = 0;
//        int a = 1;
//        int b = 1;
//        for(i=1; i<=n-2; i++){
//            c = a + b;
//            a = b;
//            b = c;
//        }
//        return c;
//    }
//}
//递归求斐波那契数
public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}