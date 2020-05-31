package Synchornized;

public class TestSynchornized4 {

    public  void func(TestSynchornized4 test) {
        synchronized (test) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        TestSynchornized4 test1 = new TestSynchornized4();
        TestSynchornized4 test2 = new TestSynchornized4();
        Thread t1 = new Thread(){
            @Override
            public void run() { test2.func(test1); }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() { test2.func(test2); }
        };
        t2.start();
        t1.join(); t2.join();
    }
}
