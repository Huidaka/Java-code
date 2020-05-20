/**
 * 两个线程必须共用一个锁对象
 */
public class ThreadWaitNotify2 {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("等待前");
                synchronized (o1){
                    try {
                        o1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("等待后");
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                System.out.println("通知前");
                synchronized (o2) {
                    o2.notify();
                }
                System.out.println("通知后");
            }
        };
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}

