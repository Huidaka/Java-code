package Huidaka;

/**
 * 利用标记终止线程地进行
 */
public class ThredBreak1 {
    static  boolean flag = true;
    static Thread t = new Thread(){
        @Override
        public void run() {
            while (flag){
                System.out.println("我还活着");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
        flag = false;
        System.out.println("我死了");
    }
}
