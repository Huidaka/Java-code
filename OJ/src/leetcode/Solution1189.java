package leetcode;

import java.util.HashMap;

/**
 * 气球的最大值
 */
public class Solution1189 {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> map = new HashMap();
        map.put('b',0);
        map.put('a',0);
        map.put('l',0);
        map.put('o',0);
        map.put('n',0);
        for(char c : text.toCharArray()){
            if(c == 'b'|| c=='a'||c=='l'||c=='o'||c=='n'){
                map.put(c,map.get(c)+1);
            }
        }
        map.put('l',map.get('l')/2);
        map.put('o',map.get('o')/2);
        int ret = map.get('l');
        for(int i : map.values()){
            if(i < ret){
                ret = i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution1189  solution1189 = new Solution1189();
        solution1189.maxNumberOfBalloons("nlaebolko");
    }
}
