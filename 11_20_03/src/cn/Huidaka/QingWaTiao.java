package cn.Huidaka;
import java.util.*;
public class QingWaTiao {
    static int count = 0;
    public static void main(String[] args){
        int n;
        System.out.println("请输入台阶数");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        qingwatiao(n);
        System.out.println(count);
    }
    public static int qingwatiao(int n){
        if(n == 1){
            count++;
            return 1;
        }
        if(n == 2){
            count += 2;
            return 2;
        }
        return qingwatiao(n-1)+qingwatiao(n-2);
    }
}
