package Huidaka;

public class Wait {
    public static void main(String[] args) {
        Object o = new Object();
        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println("等待前");
                synchronized (o) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("等待后");
            }
        };
        t.start();
    }

}
