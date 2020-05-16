public class ThreadSafety {
    static int count = 0;
    static Thread t1 = new Thread(){
        @Override
        public void run() {
            for(int i = 0; i<5000; i++){
                count++;
            }
        }
    };
    static Thread t2 = new Thread(){
        @Override
        public void run() {
            for(int i = 0; i<5000; i++){
                count++;
            }
        }
    };

    public static void main(String[] args) {
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count); //结果随机，证明线程是不安全的
    }
}
//重点是前三个
//1. 线程是抢占式运行
//2. 操作的数据是一个数据
//3. 操作不是原子性
//4. 内存可见性
//5. 操作指令重排序
