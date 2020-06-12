package nowcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * 个位数统计
 */
public class Solution24 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - '0';
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int[] arr = new int[map.size()];
        int i =0;
        for(Integer integer : map.keySet()){
           arr[i++] = integer;
        }
        Arrays.sort(arr);
        for (int k = 0; k < arr.length; k++) {
            System.out.println(arr[k]+":"+map.get(arr[k]));
        }
    }
}
