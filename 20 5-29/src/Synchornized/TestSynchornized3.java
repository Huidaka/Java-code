package Synchornized;

public class TestSynchornized3 {
    public  void func() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestSynchornized3 testSynchornized3 = new TestSynchornized3();
        Thread t1 = new Thread(){
            @Override
            public void run() { testSynchornized3.func(); }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() { testSynchornized3.func(); }
        };
        t1.start(); t2.start();
        t1.join();  t2.join();
    }
}
