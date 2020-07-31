package nowcoder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * 年月日转化天数
 */
public class Solution46 {

    public static int iConverDateToDay(int year, int month, int day) {
        if (year <=0 || month <= 0 || month > 13 || day <= 0 || day > 31)
            return -1;
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day); // Month value is 0-based. e.g., 0 for January.
        SimpleDateFormat sdf = new SimpleDateFormat("D");
        return Integer.valueOf(sdf.format(c.getTime()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input1, input2, input3;
        while (scanner.hasNext()) {
            input1 = scanner.nextInt();
            input2 = scanner.nextInt();
            input3 = scanner.nextInt();
            System.out.println(iConverDateToDay(input1, input2, input3));
        }
    }
}
