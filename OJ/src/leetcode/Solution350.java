package leetcode;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 两个数组的交集2
 */
class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0; i < nums1.length; i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        int k = 0;
        for(int j = 0; j < nums2.length; j++){
            if( map.containsKey(nums2[j]) && map.get(nums2[j]) > 0){
                nums1[k++] = nums2[j];
                map.put(nums2[j],map.getOrDefault(nums2[j],0)-1);
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
}
