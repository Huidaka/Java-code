package nowcoder;

import java.util.Scanner;

/**
 * 大整数的阶乘，用数组保存结果
 */
public class Solution20 {
    static int max = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = factorial(n);
        for (int i = max; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }

    public static int[] factorial(int n){
        int[] arr = new int[100];
        arr[0] = 1;
        int fac = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= max; j++) {
                arr[j] = arr[j] * i;
            }
            for (int j = 0; j <= max; j++) {
                if(arr[j]/10 > 9) {
                    arr[j+1] = arr[j+1] + arr[j]/10;
                    arr[j] = arr[j]%10;
                    if(j == max){
                        max++;
                    }
                }
            }
        }
        return arr;
    }
}
