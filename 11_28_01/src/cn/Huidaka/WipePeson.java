package cn.Huidaka;

import java.util.jar.JarEntry;

public class WipePeson {
    static int[] arr  = new int[]{1,2,3,4,5,6,7,8,9,10};
    static int[] arr2 = new int[arr.length];
    static int n = 3;
    public static void main(String[] args) {
        wipeperson(arr,n);
        System.out.println(arr2[n-1-1]);

    }
    public static void wipeperson(int[] arr,int n){
        int j = 0;
        if(myLength(arr2) == n-1){
            return;
        }
        else{
            for(int i = 0; i<arr.length; i++){
                if(i == n-1){
                    continue;
                }
                arr2[j] = arr[i];
                j++;
            }
            wipeperson(arr2,n);
        }
    }
    public static  int myLength(int[] arr){
        int i = 0;
        for(i = 0; i<arr.length; i++){
            if(arr[i] == 0){
                break;
            }
        }
        return i;
    }
}
