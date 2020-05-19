package Huidaka;

import java.util.Scanner;

/**
 * volatile关键字的使用
 */
public class ThreadVolatile {
    static class  Count{
        static volatile int count = 0;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while(Count.count == 0){

                }
                System.out.println("循环结束");
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                System.out.println("请输入一个整数");
                Scanner s = new Scanner(System.in);
                Count.count = s.nextInt();
            }
        };
        t1.start();
        t2.start();
    }
}
//volatile和synchornized的区别
//1 synchornized既能保证操作的原子性，又能保证内存的可见性；
//2 volatile关键字只能保证内存的可见性，不能保证操作的原子性；
//3 相比之下，volatile更轻量化不会造成线程阻塞
