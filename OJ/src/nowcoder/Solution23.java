package nowcoder;

import java.util.Scanner;

/**
 * 机器人走方格的方法
 */
public class Solution23 {
    public int countWays(int x, int y) {
        // write code here
        if(x == 1 && y == 1){
            return 1;
        }
        if(x < 1 || y < 1){
            return 0;
        }
        return countWays(x-1,y) +  countWays(x,y-1);
    }

    public static void main(String[] args){
        Solution23 solution23 = new Solution23();
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int aar[] = new int[10];
        System.out.println(aar);
        System.out.println(solution23.countWays(x,y));
    }
}
