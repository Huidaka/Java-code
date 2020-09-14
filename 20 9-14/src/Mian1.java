import java.util.Arrays;

public class Mian1 {
    public static void func(int[] arr){
        int sum = 0;
        int max = 0;
        int len = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < len; i++) {
            int k = 1;
            sum = 0;
            for (int j = i; j < len; j++) {
                sum += arr[j]*k++;
            }
            if(sum > max){
                max = sum;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,-2,-3};
        func(arr);
    }
}
