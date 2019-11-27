package cn.Huidaka;

import java.util.Scanner;

public class Split {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        n = sc.nextInt();
        split(n);
    }
    public static void split(int n){
        if(n <= 9){
            System.out.println(n);
            return;
        }
        System.out.println(n%10);
        split(n/10);
    }
}
