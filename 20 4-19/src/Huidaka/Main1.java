package Huidaka;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[1000];
        arr[0] = 0;
        arr[1] = 1;
        int i;
        for (i = 2;; i++) {
            arr[i] = arr[i-1] + arr[i-2];
            if(arr[i] == n){
                System.out.println(0);
                return;
            }
            if(arr[i] > n){
                break;
            }
        }
        int ret = Math.min(arr[i] - n, n - arr[i - 1]);
        System.out.println(ret);
        return;
    }
}
