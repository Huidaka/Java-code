/**
 * 线程锁： 重点要明白锁的对象
 */
public class SynchronizedThread {
    static int count = 0;
    static class Test{
        synchronized public void func(){
            count++;
        }

    }

    public static void main(String[] args) {
        Test t = new Test();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("线程1开始运行");
                for (int i = 0; i < 5000; i++) {
                    t.func();
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public  void run() {
                System.out.println("线程2开始运行");
                for (int i = 0; i < 5000; i++) {
                    t.func();
                }
            }
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
//synchronized修饰普通方法代表锁的是当前对象；
//synchronized修饰static方法代表锁的是类对象；
//synchronized修饰代码块，通过synchornized（）{}括号中来确定锁的对象
