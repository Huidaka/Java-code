package leetcode;

import java.util.Arrays;

/**
 * 两个数组的交集2(进阶排序)
 */
public class Solution350_1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0,j = 0,k = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }
            else if(nums1[i] > nums2[j]){
                j++;
            }
            else{
                nums1[k++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
}
