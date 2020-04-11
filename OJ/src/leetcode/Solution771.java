package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 宝石的品种
 */
public class Solution771 {
    class Solution {
        public int numJewelsInStones(String J, String S) {
            Set<Character> set = new HashSet<>();
            int count = 0;
            //1、把J中的字符 存放到集合set当中
            char[] arrJ = J.toCharArray();
            char[] arrS = S.toCharArray();
            for (int i = 0; i < arrJ.length; i++) {
                set.add(arrJ[i]);
            }
            //2、遍历字符串S，判断每一个字符是否存在于集合当中
            //存在 就让count++;
            for (int j = 0; j < arrS.length; j++) {
                if(set.contains(arrS[j])){
                    count++;
                }
            }
            return count;
        }
    }

}
