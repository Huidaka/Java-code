package leetcode;
import java.util.HashMap;
import java.util.Map;

/**
 * map解决同构字符串
 */
public class Solution205_1 {
    public boolean isIsomorphic(String s, String t) {
        if(s.equals(t)){
            return true;
        }
        Map<Character,Character> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if(map.containsKey(ss)){
                if(map.get(ss) != tt)
                    return false;
            }
            else{
                if(map.containsValue(tt)) return false;
                map.put(ss,tt);
            }
        }
        return true;
    }
}