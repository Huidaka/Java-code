package nowcoder;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * topk问题
 */
public class Solution18 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split("\\ ");
        int k = Integer.parseInt(strs[strs.length-1]);
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] arr = new int[strs.length-1];
        for(int i = 0; i < strs.length-1; i++){
            arr[i] = Integer.parseInt(strs[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if(i<k){
                queue.add(arr[i]);

            }
            else{
                if(arr[i] < queue.peek()) {
                    queue.poll();
                    queue.add(arr[i]);
                }
            }
        }
        int[] ret = new int[k];
        for (int i = k-1; i >= 0; i--) {
            ret[i] = queue.poll();
        }
        for (int i = 0; i < k; i++) {
            System.out.print(ret[i]+" ");
        }
    }
}
