package cn.Huidaka;
//时间复杂度优先，O(n),空间复杂度O（n） 判断一个数组中是否有重复数字
public class RepeatNumber {
    public static void main(String[] args) {
        int[] arr1 = new int[] {2,3,5,4,3,2,6,7};
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if(arr2[arr1[i]] != 0){
                System.out.println(arr1[i]);
                return;
            }
            arr2[arr1[i]] = arr1[i];
        }
    }
}
