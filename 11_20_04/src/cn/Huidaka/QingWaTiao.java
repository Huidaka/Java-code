package cn.Huidaka;
import java.util.*;
import java.math.*;
public class QingWaTiao {
    static int count = 0;
    public static void main(String[] args){
        int n;
        System.out.println("请输入台阶数");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        qingwatiao(n);
        System.out.println(qingwatiao(n));
    }
    public static int qingwatiao(int n){
        if(n == 1) {
            return 1;
        }
        int sum = 0;
        int i = 1;
        while (i < n) {
            sum += qingwatiao(n - i);
            i++;
        }
        return sum+1;
    }
}
