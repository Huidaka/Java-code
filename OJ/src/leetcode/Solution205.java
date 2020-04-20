package leetcode;
/**
 * 同构字符串
 */

import java.util.HashMap;
import java.util.Map;

public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        if(s.equals(t)){
            return true;
        }
        int[] arr1 = addStringToMap(s);
        int[] arr2 = addStringToMap(t);
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    private int[] addStringToMap( String s){
        Map<Character,Integer> map = new HashMap();
        int[] arr = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                arr[i] = map.get(s.charAt(i));
                continue;
            }
            map.put(s.charAt(i),i);
            arr[i] = i;
        }
        return arr;
    }
}
