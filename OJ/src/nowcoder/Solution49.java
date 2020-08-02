package nowcoder;
/**
 * 最长连续数字子串
 */

import java.util.*;
public class Solution49{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int max = 0;
        String str1 = "";
        String str = scan.nextLine();
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                str1 += c;
            } else {
                str1 += "a";
            }
        }
        String[] strs = str1.split("a");
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() > max) {
                max = strs[i].length();
            }
        }
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() == max) {
                System.out.print(strs[i]);
            }
        }
    }
}
