/**
 * 使用wail方法让线程进入等待waiting状态，在使用notify方法让线程重新今天runnable状态
 */
public class ThreadWaitNotify {
    public static void main(String[] args) {
        Object o = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("等待前");
                synchronized (o){
                    try {
                        o.wait();
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
                synchronized (o) {
                    o.notify();
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
