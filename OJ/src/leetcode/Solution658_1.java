package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找寻找最接近x的k个数
 */
public class Solution658_1 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;
        int mid = 0;
        while (left < right){
            mid = (left + right) >>> 1;
            if(Math.abs(x - arr[mid]) > Math.abs(x - arr[mid+k])){
                left = left + 1;
            }
            else{
                right = mid;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = right; i < right + k; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
