package com.gaoxin;
import java.util.*;
public class GuessNumberGame {
    public static void main(String[] args){
        int n = 0;
        int i;
        Scanner sc = new Scanner(System.in);
        do {
            mean();
            System.out.print("请选择");
            n = sc.nextInt();
            if(n ==1){
                game();
            }
        } while(n == 1);
    }
    public static void mean(){
        System.out.println("***********猜 数 字 游 戏*************");
        System.out.println("***********  1. Play    *************");
        System.out.println("***********  2. exit    *************");
    }
    public static void game() {
        System.out.println("请输入你猜的数字");
        int m = 0;
        int x;
        Random random = new Random();
        m = (int)(Math.random()*100);
        Scanner sc = new Scanner(System.in);
        do {
            x = sc.nextInt();
            if (m > x) {
                System.out.println("猜小了");
            } else if (m < x) {
                System.out.println("猜大了");
            }
        }while (m != x);
        System.out.println("猜对了");
    }
}
