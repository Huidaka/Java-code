
public class ThreadState {
    static Thread t = new Thread(){
        @Override
        public void run() {
            System.out.println("我是一个新线程");
        }
    };

    public static void main(String[] args) {
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        try {
            t.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getState());
    }
}
//NEW : 代表线程对象准备好，而PCB对象没有准备好，新创建的，但是还没有运行start方法
//RUNNABLE ： 代表已经执行力start方法，线程处于就绪状态，但是并不一定要执行run方法，还需要等待cpu的时间
//BOLCKED ： 代表当前线程在等待锁
//TIMED WAITING ： 阻塞状态，程序遇见sleep方法就会处于这个状态
//WATING ： 和信号集有关
// TERMINATED : PCB对象已经销毁，但是Thread对象没有销毁
