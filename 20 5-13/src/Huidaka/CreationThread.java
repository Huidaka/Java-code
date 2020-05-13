package Huidaka;

import java.util.TimerTask;


public class CreationThread {
    //继承Thread类
    static class MyThread1 extends Thread{
        public void run(){
            System.out.println("我是一个新线程4");
            while (true){

            }
        }
    }
    //实现Runnable接口
    static class MyThread2 implements Runnable{

        @Override
        public void run() {
            System.out.println("我是一个新线程5");
            while (true){

            }
        }
    }
    public static void main(String[] args) {
        //根据匿名内部类，创建一个新线程
        Thread t1 = new Thread("我是一个新线程"){
            @Override
            public void run() {
                System.out.println("我是一个新线程1");
                while (true){

                }
            }
        };
        //匿名内部类实现Runnable接口，创建一个线程对象;
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是一个新线程2");
                while (true){

                }
            }
        });
        //根据lamada表达式创建线程对象
        Thread t3 = new Thread(()->{
            System.out.println("我是一个新线程3");
            while (true){

            }
        });

        MyThread1 myThread1 = new MyThread1();
        Thread t4 = new Thread(new MyThread2());
        t1.start();
        t2.start();
        t3.start();
        myThread1.start();
        t4.start();
        while (true){

        }
    }
}

