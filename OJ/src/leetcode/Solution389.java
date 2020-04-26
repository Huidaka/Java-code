package leetcode;

import java.util.HashMap;

/**
 * 找两个字符串的不同
 * hashmap解法
 */
public class Solution389 {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        char ret = '0';
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int j = 0; j < t.length(); j++){
            if(map.containsKey(t.charAt(j)) && map.get(t.charAt(j)) != 0){
                map.put(t.charAt(j),map.get(t.charAt(j))-1);
            }
            else{
                ret = t.charAt(j);
                break;
            }
        }
        return ret;
    }
}
