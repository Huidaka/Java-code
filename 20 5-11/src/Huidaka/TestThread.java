package Huidaka;

/**
 * 创建一个新的线程
 */
public class TestThread {
    static class  MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("新的线程");
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
    }
}
