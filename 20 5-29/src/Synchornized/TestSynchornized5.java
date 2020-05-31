package Synchornized;

public class TestSynchornized5 {
    public static synchronized void func() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestSynchornized5 testSynchornized1 = new TestSynchornized5();
        TestSynchornized5 testSynchornized2 = new TestSynchornized5();
        Thread t1 = new Thread(){
            @Override
            public void run() { testSynchornized1.func(); }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() { testSynchornized2.func(); }
        };
        t1.start(); t2.start();
        t1.join();  t2.join();
    }
}
