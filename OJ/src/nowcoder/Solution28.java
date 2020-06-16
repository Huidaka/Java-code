package nowcoder;

import java.util.Scanner;

/**
 *验证尼克斯定理
 */
public class Solution28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int count = n * (n - 1) / 2;
            int flag = count * 2 + 1;
            StringBuilder ret = new StringBuilder();
            for (int i = 0; i < n; i++) {
                ret.append(flag + "+");
                flag += 2;
            }
            System.out.println(ret.substring(0, ret.length() - 1));
        }
    }
}
