import java.util.Arrays;

public class Solution {
    /**
     * 
     * @param nums int整型一维数组 
     * @return int整型
     */
    public int firstMissingPositive (int[] nums) {
        // write code here
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0 && nums[i+1]-nums[i] != 1){
                return nums[i] + 1;
            }
        }
        return -1;
    }
}