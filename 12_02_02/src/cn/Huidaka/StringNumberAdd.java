package cn.Huidaka;

import java.util.Scanner;

//public class StringNumberAdd {
//    private String str = "";
//    private String str1;
//    private String str2;
//    private int m;
//    private int n;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        StringNumberAdd s = new StringNumberAdd();
//        s.str1 = sc.nextLine();
//        s.str2 = sc.nextLine();
//        s.m = Integer.parseInt(s.str1);
//        s.n = Integer.parseInt(s.str2);
//        System.out.println(s.m+s.n);
//    }
//}
public class StringNumberAdd {
    private String str = "";
    private String str1;
    private String str2;
    private char[] arr1 = new char[30];
    private char[] arr2 = new char[30];
    private int n;
    private int m;
    public int charToInt(char[] arr){
        int num = 0;
        for(int i=0; i<arr.length; i++){
            num +=( arr[i] - '0')* Math.pow(10,arr.length-i-1);
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringNumberAdd s = new StringNumberAdd();
        s.str1 = sc.nextLine();
        s.arr1 = s.str1.toCharArray();
        s.str2 = sc.nextLine();
        s.arr2 = s.str2.toCharArray();
        s.m = s.charToInt(s.arr1);
        s.n = s.charToInt(s.arr2);
        System.out.println(s.m+s.n);
    }
}