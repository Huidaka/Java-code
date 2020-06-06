package nowcoder;

import java.util.Scanner;

/**
 * 计算糖果
 */
public class Solution14{
    public static void main(String args[]){
        int a = 0;
        int b = 0;
        int c = 0;
        int[] arr = new int[4];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        b = (arr[2] - arr[0])/2;
        a = b + arr[0];
        c = b - arr[1];
        if(b + c == arr[3]){
            System.out.print(a+" ");
            System.out.print(b+" ");
            System.out.print(c);
        }
        else{
            System.out.println("No");
        }
    }
}
