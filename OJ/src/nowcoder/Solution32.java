package nowcoder;

import java.util.Scanner;

/**
 * 奇偶校验
 */
public class Solution32 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            for(int i = 0; i<str.length(); i++){
                int num = str.charAt(i);
                int[] arr = TenToTwo(num);
                for(int j = arr.length-1; j>=0; j--){
                    System.out.print(arr[j]);
                }
                System.out.println();
            }
        }
    }
    public static int[] TenToTwo(int num){
        int[] arr = new int[8];
        int i = 0;
        int count = 0;
        while(num != 0){
            arr[i] = num%2;
            if(arr[i] == 1){
                count++;
            }
            num = num/2;
            i++;
        }
        if(count%2 == 0){
            arr[7] = 1;
        }
        else{
            arr[7]  = 0;
        }
        return arr;
    }
}
