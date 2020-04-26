package leetcode;

/**
 * 找两个字符串的不同
 * 异或运算解法
 */
public class Solution389_1 {
    public char findTheDifference(String s, String t) {
        char ret = 0;
        for(int i = 0; i < s.length(); i++){
            ret ^= s.charAt(i) ^ t.charAt(i);
        }
        ret ^= t.charAt(s.length());
        return ret;
    }
}
