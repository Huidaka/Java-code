package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 两个数组的交集
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> map = new HashSet();
        for(int i = 0; i < nums1.length; i++){
            map.add(nums1[i]);
        }
        int k = 0;
        for(int i = 0; i < nums2.length; i++){
            if(map.contains(nums2[i])){
                nums1[k++] = nums2[i];
                map.remove(nums2[i]);
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
}
