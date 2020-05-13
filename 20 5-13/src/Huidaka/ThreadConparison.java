package Huidaka;

public class ThreadConparison {
    static long n = 100_0000_0000L;
    static public void oneThread(){
        int a = 0;
        int b = 0;
        long begin = System.currentTimeMillis();
        for (long i = 0; i < n; i++) {
            a++;
        }
        for (long i = 0; i < n; i++) {
            b++;
        }
        long end = System.currentTimeMillis();
        System.out.println("单线程时间：" + (end - begin) + "ms");
    }

    static public void muchThread(){
        long begin = System.currentTimeMillis();
        Thread t = new Thread(){
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < n; i++) {
                    a++;
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                int b = 0;
                for (long i = 0; i < n; i++) {
                    b++;
                }
            }
        };
        t.start();
        t2.start();
        try {
            t.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("多线程时间：" + (end - begin) + "ms");
    }

    public static void main(String[] args) {
        oneThread();
        muchThread();
    }
}
