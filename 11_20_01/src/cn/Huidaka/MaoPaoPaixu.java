package cn.Huidaka;
import java.util.*;
public class MaoPaoPaixu {
    public  static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        n = sc.nextInt();
        System.out.println(maoPaoPaixu(n));
    }
    public static int maoPaoPaixu(int n){
        if(n <= 10){
            return n;
        }
        return n%10 + maoPaoPaixu(n/10);
    }
}
