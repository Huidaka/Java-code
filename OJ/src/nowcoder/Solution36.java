package nowcoder;
/**
 *数组中出现一次的数字
 */

import java.util.HashSet;
import java.util.Scanner;

public class Solution36 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet(2);
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            if(set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }
        int[] arr = new int[2];
        int j = 0;
        for(Integer i : set){
            arr[j++] = i;
        }
        if(arr[0] > arr[1]){
            System.out.print(arr[1] + " " + arr[0]);
        }
        else{
            System.out.print(arr[0] + " " + arr[1]);

        }
    }
}
