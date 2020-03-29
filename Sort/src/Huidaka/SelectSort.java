package Huidaka;

import java.util.Arrays;

/**
 * 选择排序
 * 核心思想：每一次从无序区间选出最大（或最小）的一个元素，存放在无序区间的最后（或最前），直到全部待排序的数据元
 * 素排完 。
 * 时间复杂度O（n^2）
 * 空间复杂度O（1）
 * 稳定性：不稳定
 */
public class SelectSort {

    public void selectSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[i]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] array = {12,4,6,9,2,54,80,45,87,96,25,25,52,8,32};
        selectSort.selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
