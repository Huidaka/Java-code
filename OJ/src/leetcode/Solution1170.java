package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 比较字符串最小字母出现的频率
 */
public class Solution1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] flag = new int[words.length];
        for(int k=0; k<words.length; k++){
            flag[k] = f(words[k]);
        }
        Arrays.sort(flag);
        int[] arr = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int temp = f(queries[i]);
            for(int j=0; j<words.length; j++){
                if(temp < flag[j]){
                    arr[i] = flag.length - j;
                    break;
                }
            }
        }
        return arr;
    }

    private int f(String s){
        HashMap<Character,Integer> map = new HashMap();
        char temp = s.charAt(0);
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
            if(c < temp){
                temp = c;
            }
        }
        return map.get(temp);
    }
}
