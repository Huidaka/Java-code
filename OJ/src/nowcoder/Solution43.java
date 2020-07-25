package nowcoder;

public class Solution43 {
    /**
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public static int calculateMax(int[] prices) {
        int sum = 0;
        int temp = 0;
        for (int i = 1; i < prices.length; i++) {
            temp = getMax(prices,0,i) + getMax(prices,i,prices.length-1);
            if(temp > sum){
                sum = temp;
            }
        }
        return sum;
    }

    private static int getMax(int[] arr, int start, int end){
        int max = 0;
        int min = arr[start];
        for (int i = start+1; i <= end ; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
            if(arr[i] - min > max){
                max = arr[i] - min;
            }
        }
        return max;
    }
}