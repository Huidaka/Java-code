package leetcode;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 利用快速排序法排列一个数组
 */
public class Solution912 {
    public List<Integer> sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        List<Integer> list1 = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return list1;
    }

    public int[] quickSort(int[] arr,int left , int right) {
        if((left==right) || (left>right)){
            return  arr;
        }
        int flag = arr[right];
        int flagLeft = left;
        int flagRight = right;
        while (left<right) {
            while ((arr[left] <= flag) && (left<right)) {
                ++left;
            }
            while ((arr[right] >= flag) && (left<right)) {
                --right;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        int temp2 = arr[left];
        arr[left] = arr[flagRight];
        arr[flagRight] = temp2;
        quickSort(arr,flagLeft,right-1);
        quickSort(arr,left+1,flagRight);
        return arr;
    }
}
