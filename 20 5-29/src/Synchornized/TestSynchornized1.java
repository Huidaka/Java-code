package Synchornized;

public class TestSynchornized1 {
    int n = 0;
    public synchronized void func(){
        n++;
    }
    public static void main(String[] args) throws InterruptedException {
        TestSynchornized1 testSynchornized1 = new TestSynchornized1();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i<5000; i++) {
                    testSynchornized1.func();
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i<5000; i++) {
                    testSynchornized1.func();
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(testSynchornized1.n);
    }
}
