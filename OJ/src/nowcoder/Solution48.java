package nowcoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 找前k个最小数
 */
public class Solution48 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k>input.length || k == 0){
            return new ArrayList();
        }
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < input.length; i++) {
            if(i < k) {
                queue.add(input[i]);
            }
            else{
                if(input[i] < queue.peek()){
                    queue.poll();
                    queue.add(input[i]);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>(queue);
        return list;
    }

    public static void main(String[] args) {
        int[] input ={4,5,2,6,1,7,3,8};
        GetLeastNumbers_Solution(input,4);
    }
}
