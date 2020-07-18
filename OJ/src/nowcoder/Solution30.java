package nowcoder;

import java.util.Scanner;

/**
 * 年会抽奖
 * 全都不获奖的计算公式G(n) = (n-1) * (G(n-1) + G(n-2))
 */
public class Solution30 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            float moleclue = Calculate(n);
            float denominator = func(n);
            System.out.printf("%.2f",moleclue*100.0f/denominator);
            System.out.println("%");
        }
    }
    public static float Calculate(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        return (n-1)*(Calculate(n-1)+Calculate(n-2));
    }
    public static float func(int n){
        if(n == 1){
            return 1;
        }
        return n*func(n-1);
    }
}
