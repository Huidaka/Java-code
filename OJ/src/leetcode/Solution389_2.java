package leetcode;

/**
 * 找两个字符串的不同
 * ascII码值解法
 */
public class Solution389_2 {
    public char findTheDifference(String s, String t) {
        char ret = 0;
        int n = 0 ,m = 0;
        for(int i = 0; i < s.length(); i++){
            n += s.charAt(i);
        }
        for(int i = 0; i < t.length(); i++){
            m += t.charAt(i);
        }
        ret = (char)(m-n);
        return ret;
    }
}
