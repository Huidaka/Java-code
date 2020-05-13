package Huidaka;

public class ThreadBreak2 {
    static Thread t = new Thread(){
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("我还活着");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    };

    public static void main(String[] args) {
        t.start();
        try {
            t.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("有内鬼终止交易");
        t.interrupt();
        System.out.println("我死了");
    }
}
