package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 只出现一次的数字
 */
public class Solution136_1 {
    public int singleNumber(int[] nums) {
        int ret = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }
            else{
                set.add(nums[i]);
            }
        }
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            ret = it.next();
        }
        return ret;
    }
}

