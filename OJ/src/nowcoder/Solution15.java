package nowcoder;

import java.util.HashMap;
import java.util.Scanner;

/**
 *  出现次数大于一半的数字
 */
public class Solution15 {
    public static void main(String args[]){
        int count = 0;
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> map = new HashMap();
        while(sc.hasNext()){
            map.put(sc.nextInt(),map.getOrDefault(sc.nextInt(),0)+1);
            count++;
        }
        for (Integer integer : map.keySet()) {
            if(map.get(integer) >= count/2){
                System.out.println(integer);
            }
        }
    }
}
