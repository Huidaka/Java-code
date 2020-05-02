package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复元素2
 */
public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int flag = map.get(nums[i]);
                int count = 1;
                for(int j=0; j<nums.length; j++){
                    if(nums[j] == nums[i]){
                        if(count == flag && Math.abs(i-j) <= k){
                            return true;
                        }
                        count++;
                    }
                }
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return false;
    }
}
