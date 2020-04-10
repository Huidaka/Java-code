package leetcode;

import nowcoder.Solution;

/**
 * 比较版本号
 *
 */
public class Solution165 {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int len1 = s1.length , len2 = s2.length;
        for (int i = 0; i < Math.max(len1,len2); i++) {
            int num1 = i < len1 ? Integer.parseInt(s1[i]) : 0;
            int num2 = i < len2 ? Integer.parseInt(s2[i]) : 0;
            if(num1 < num2 || num1 > num2){
                return num1 < num2 ? -1 : 1;
            }
        }
        return 0;
    }
}
