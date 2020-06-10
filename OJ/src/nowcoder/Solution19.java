package nowcoder;

import java.util.Scanner;

/**
 * 求阶乘末尾0的个数（求分解质因数中5的个数）
 *
 */
public class Solution19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int count = 0;
            for (int i = n; i > 1; i--) {
                int temp = i;
                while (temp%5 == 0){
                    count++;
                    temp = temp / 5;
                }
            }
            System.out.println(count);
        }
    }
}
