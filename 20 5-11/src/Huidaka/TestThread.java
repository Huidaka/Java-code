package Huidaka;

/**
 * 创建一个新的线程
 */
public class TestThread {
    static class  MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("新的线程");
            //run方法运行完后会自动结束掉这个线程
            while(true){

            }
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
        System.out.println("新线程执行完毕");
    }
}
