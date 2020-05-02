package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set =  new HashSet();
        for(int i=0; i < nums.length; i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
