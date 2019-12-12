package cn.Huidaka;

import java.util.Scanner;

public class DiGuiMaoPao {
    public static void main(String[] args){
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        diGuiMaopao(arr);
        for(int i = 0; i<arr.length; i++){
            System.out.print(" "+arr[i]);
        }
    }
    public static int[] diGuiMaopao(int[] arr){
        int i;
        int tmp = 0;
        for(i=0; i<arr.length-1; i++ ){
            if(arr[i] > arr[i+1]){
                tmp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = tmp;
                return diGuiMaopao(arr);
            }
        }
        return arr;
    }
}
