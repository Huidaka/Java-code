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
