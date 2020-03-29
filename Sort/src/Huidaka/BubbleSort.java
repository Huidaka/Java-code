package Huidaka;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * 冒泡排序
 * 核心思想：通过相邻数的比较，将最大的数冒泡到无序区间的最后，持续这个过程，直到数组整体有序
 * 最坏时间复杂度：O（n^2）
 * 最好时间复杂度；O（n），优化完
 * 空间复杂度：O（1）
 * 稳定性：稳定
 */
public class BubbleSort {
    public static void bubbleSort(int[] array) {
        boolean flag = false;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {12,4,6,9,2,54,80,45,87,96,25,25,52,8,32};
        bubbleSort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
