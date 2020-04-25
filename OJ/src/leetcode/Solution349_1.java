package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 两个数组的交集（使用java内置聚合函数retainAll()）
 */
public class Solution349_1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet();
        for(int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }
        HashSet<Integer> set2 = new HashSet();
        for(int i = 0; i < nums2.length; i++){
            set2.add(nums2[i]);
        }
        set1.retainAll(set2);
        int k = 0;
        for(Integer n : set1){
            nums1[k++] = n;
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
}
