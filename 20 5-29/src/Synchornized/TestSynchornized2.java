package Synchornized;

import java.util.TreeMap;

public class TestSynchornized2 {
    String name;
    public TestSynchornized2(String name) {
        this.name = name;
    }
    public synchronized void func() {
        for (int i = 0; i < 10; i++) {
            System.out.print(name+"Ï÷Æ»¹û"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) throws InterruptedException {
//        TestSynchornized2 testSynchornized2 = new TestSynchornized2();
//        Thread t1 = new Thread(){
//            @Override
//            public void run() {
//                testSynchornized2.func();
//            }
//        };
//        Thread t2 = new Thread(){
//            @Override
//            public void run() {
//                testSynchornized2.func();
//            }
//        };
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//    }
public static void main(String[] args) throws InterruptedException {
    TestSynchornized2 ts1 = new TestSynchornized2("»úÆ÷1");
    TestSynchornized2 ts2 = new TestSynchornized2("»úÆ÷2");
    Thread t1 = new Thread(){
        @Override
        public void run() {
            ts1.func();
        }
    };
    Thread t2 = new Thread(){
        @Override
        public void run() {
            ts2.func();
        }
    };
    t1.start();
    t2.start();
    t1.join();
    t2.join();
}
}
