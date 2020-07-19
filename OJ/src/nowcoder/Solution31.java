package nowcoder;

import java.util.Scanner;

/**
 * （动态规划）数字和组成sum的方案数
 */
public class Solution31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] arr = new int[n];
        //存放由i个数字组成和为j的方案数
        long[][] dp = new long[n+1][sum+1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long ret = DynamicPlanning(dp,arr,n,sum);
        System.out.println(ret);
    }
    //动态规划 方程 F(i,j) = F(i-1,j-arr[i-1]) + F(i-1,j)
    public static long DynamicPlanning(long[][] dp, int[] arr, int num, int sum){
        //和为0只能一个都不选，只有一种方案
        for (int i = 0; i <= num; i++) {
            dp[i][0] = 1;
        }
        //0个数什么都组成不了所以是0个方案
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= sum; j++) {
                if(arr[i-1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i-1]] + dp[i - 1][j];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[num][sum];
    }
}
