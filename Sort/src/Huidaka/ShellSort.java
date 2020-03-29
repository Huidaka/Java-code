package Huidaka;

import java.util.Arrays;

/**
 *希尔排序
 * 核心思想：分组进行插入排序
 * 最好时间复杂度：O（n）
 * 最坏时间复杂度：O（n^2）
 * 平均时间复杂度：O（n^1.3）
 * 空间复杂度O（1）
 * 稳定性：不稳定
 */
public class ShellSort {
    //直接插入排序
    public void shell(int[] array,int gap) {
        int j;
        for (int i = gap; i < array.length; i++) {
            int temp = array[i];
            for (j = i-gap; j >= 0 ; j -= gap) {
                if(array[j] > temp){
                    array[j+gap] = array[j];
                }
                else{
                    break;
                }
            }
            array[j+gap] = temp;
        }
    }
    //分组
    public void shellSort(int[] array) {
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] array = {12,4,6,9,2,54,80,45,87,96,25,25,52,8,32};
        shellSort.shellSort(array);
        System.out.println(Arrays.toString(array));
    }

}
