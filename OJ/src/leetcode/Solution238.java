package leetcode;

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length-1;
        int sum = 1;
        int sumL = 1;
        int[] arr = new int[nums.length];
        for(int i=0;i<=n;i++){
            if(i>n-i){
                arr[i] = sum*arr[i];
                arr[n-i]=sumL*arr[n-i];
            }else if(i==n-i){
                arr[i] = sum*sumL;
            }else {
                arr[i]=sum;
                arr[n-i]=sumL;
            }
            sum*=nums[i];
            sumL*=nums[n-i];
        }
        return arr;
    }
}

作者：zhangbaipeng
        链接：https://leetcode-cn.com/problems/product-of-array-except-self/solution/java-zuo-ji-you-ji-by-zhangbaipeng/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
