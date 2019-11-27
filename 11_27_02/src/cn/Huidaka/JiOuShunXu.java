package cn.Huidaka;

public class JiOuShunXu {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        oderArray(arr);
        for (int i = 0;i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void oderArray(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            while(left<right && arr[left]%2 == 0){
                left++;
            }
            while(left<right && arr[right]%2 != 0){
                right--;
            }
            if(left<right){
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
    }
}
