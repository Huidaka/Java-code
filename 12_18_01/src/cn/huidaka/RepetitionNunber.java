package cn.huidaka;
//找出数组中的任一个重复数字
public class RepetitionNunber {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};
        int m;
        for (int i = 0; i < arr.length; i++) {
            while(i != arr[i]){
                m = arr[i];
                if(m == arr[m]){
                     System.out.println(arr[m]);
                    for (int n:arr
                    ) {
                        System.out.print(n + " ");
                    }
                    return;
                }
                int temp = arr[i];
                arr[i] = arr[m];
                arr[m] = temp;
            }
        }
        System.out.println("没有重复元素");
        return;
    }
}
