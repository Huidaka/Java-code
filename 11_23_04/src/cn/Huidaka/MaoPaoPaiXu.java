package cn.Huidaka;

import java.util.Scanner;

public class MaoPaoPaiXu {
    public static void main(String[] args){
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        maoPaoPaixu(arr);
        for(int i = 0; i<arr.length; i++){
            System.out.print(" "+arr[i]);
        }
    }
    public static int[] maoPaoPaixu(int[] arr){
        int i = 0;
        int j = 0;
        boolean flage = false;
        for(i=0; i<arr.length-1; i++){
            for(j=0; j < arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                     int tmp = arr[j];
                     arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                     flage = true;
                }
                if(!flage){
                    return arr;
                }
            }
        }
        return arr;
    }
}
