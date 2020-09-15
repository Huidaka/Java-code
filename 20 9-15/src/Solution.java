public class Solution {
    /**
     * 数组内数据循环平移
     * @param arr int整型一维数组 输入数组
     * @param pushOffset int整型 位移长度
     * @return int整型一维数组
     */
    public int[] pushIntArray (int[] arr, int pushOffset) {
        // write code here
        int len = arr.length;
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            ret[(i+pushOffset)%len] = arr[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};

    }
}