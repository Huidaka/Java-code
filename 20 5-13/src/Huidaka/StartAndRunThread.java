package Huidaka;

import static java.lang.Thread.sleep;

/**
 * 调用run方法和start方法启动线程的区别
 */
public class StartAndRunThread {

    static Thread t1 = new Thread(()->{
        while(true) {
            System.out.println("我是一个新线程1");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    static Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true) {
                System.out.println("我是一个新线程2");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });
    public static void main(String[] args) {
//        t1.start();
//        t2.start();
          t1.run(); //调用run就会变成串行进程
          t2.run();
    }
}
