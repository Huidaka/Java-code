package nowcoder;

import java.util.Scanner;

/**
 * 年月日转化天数
 */
public class Solution46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
            if(year%400 == 0 && year%100 == 0 || (year%100!=0 && year%4==0 && year%100!=0)){
                days[1] = 29;
            }
            int res = 0;
            for (int i = 1; i < month; i++) {
                res += days[i-1];
            }
            res = res + day;
            System.out.println(res);
        }
    }
}
