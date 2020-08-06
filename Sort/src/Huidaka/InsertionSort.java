package Huidaka;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * 插入排序
 * 最坏时间复杂度；O(n^2)
 * 最好的的时间复杂度；O(n)
 * 特点: 数据越有序，排序速度越快
 * 排序思想：逐个和前边元素比较，找到比自己小的直接插入
 */
public class InsertionSort {
    public static void insertSort(int[] array) {
        for(int i=1,j=0; i<array.length; i++){
            int temp = array[i];
            for(j = i-1; j>=0; j--){
                if(temp < array[j]){
                    array[j+1] = array[j];
                }
                else{
                    break;
                }
            }
            array[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {12,4,6,9,2};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

}
