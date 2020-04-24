package leetcode;

import java.util.HashMap;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1
 */
public class Solution387 {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap();
        char[] c = s.toCharArray();
        for(char c1 : c){
            map.put(c1,map.getOrDefault(c1,0)+1);
        }
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
