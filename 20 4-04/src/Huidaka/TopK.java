package Huidaka;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 实现topk问题
 * 找前k个最大的元素，建立小堆
 * 找前k个最小的元素，建立大堆
 */
class TopKComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}

public class TopK {
    public Integer[]  findKNum(Integer[] array, int k){
        TopKComparator topKComparator = new TopKComparator();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(k,topKComparator);
        for (int i = 0; i < array.length; i++) {
            if(priorityQueue.size() < k){
                priorityQueue.offer(array[i]);
            }
            else{
                if(array[i] < priorityQueue.peek()){
                    priorityQueue.poll();
                    priorityQueue.offer(array[i]);
                }
            }
        }
        Integer[]  ret = new Integer[k];
        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll();
        }
        return ret;
    }

    public static void main(String[] args) {
        TopK topK = new TopK();
        Integer[]  array = {45,65,5,8,25};
        System.out.println(Arrays.toString(topK.findKNum(array, 3)));

    }
}
