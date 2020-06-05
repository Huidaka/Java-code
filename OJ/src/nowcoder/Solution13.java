package nowcoder;

import java.util.Scanner;

/**
 * 有一个神奇的口袋，总的容积是40，
 * 用这个口袋可以变出一些物品，这些物品的总体积必须是40。
 * John现在有n个想要得到的物品，每个物品的体积分别是a1，a2……an。John可以从这些物品中选择一些，如果选出的物体的总体积是40，
 * 那么利用这个神奇的口袋，John就可以得到这些物品。现在的问题是，John有多少种不同的选择物品的方式。
 *
 */
public class Solution13 {

    //保存物品的种类和体积
    private static int[] arr = null;
    //保存有多少中方法
    private static int count;
    static int n  = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        count(40,n);
        System.out.println(count);
    }
    public static void count(int s, int n){
        if(s == 0){
            count++;
        }
        if(s <= 0 || (n <= 0 && s > 0)){
            return;
        }
        count(s-arr[n],n-1);
        count(s,n-1);
    }
}