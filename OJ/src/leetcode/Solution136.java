package leetcode;

/**
 * 只出现一次的数字
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }
}
