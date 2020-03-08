package Huidaka;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输出字符串的字符集，去掉重复元素
 */
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Test(str);
    }
    public static char[] Test(String str){
        int flag = 0;
        char[] arr1 = str.toCharArray();
        char[] arr2 = new char[arr1.length];
        arr2[0] = arr1[0];
        System.out.print(arr2[0]);
        flag++;
        for (int i=1; i < arr1.length; i++) {
            int j = 0;
            for (; j < flag; j++) {
                if(arr1[i] == arr2[j]){
                    break;
                }
            }
            if(arr1[i] == arr2[j]){
                continue;
            }
            arr2[j] = arr1[i];
            flag++;
            System.out.print(","+arr1[i]);
        }
        return arr2;
    }
}
