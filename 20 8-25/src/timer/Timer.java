package timer;

import java.util.concurrent.PriorityBlockingQueue;

public class Timer {
    //利用优先级阻塞对列来存放任务（take方法会进行阻塞，即队列内容为空的时候会进行阻塞）
    private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();

    public Timer() {
        Work work = new Work();
        work.start();
    }
    //实现Comparable接口让Task类可以进行排序比较
    //Comparable是内比较器，Comparator是外比较器
    class Task implements Comparable<Task> {
        private long time;
        private Runnable runnable;

        public Task(long time, Runnable runnable) {
            this.time = time + System.currentTimeMillis();
            this.runnable = runnable;
        }

        public void run(){
            Thread thread = new Thread(runnable);
            thread.start();
        }

        @Override
        public int compareTo(Task o) {
            return (int)(this.time-o.time);
        }
    }

    class Work extends Thread{
        @Override
        public void run() {
            while (true) {
                long time = System.currentTimeMillis();
                Task task = null;
                try {
                    task = queue.take();
                    if (task.time > time) {
                        queue.put(task);
                        //之所以加锁是因为调用wait和notify方法需要本线程获得该对象的监视器锁
                        //调用wait方法防止线程进行无用的扫描
                        synchronized (this) {
                            wait(task.time - time);
                        }
                    } else {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void put(Runnable runnable, long time){
        Task task = new Task(time,runnable);
        queue.put(task);
        //此处调用notify方法是为了防止新加入的线程任务级别高于正在等待任务的级别
        synchronized (this) {
            notify();
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        for (int i = 1; i<10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("闹钟响了");
                }
            };
            timer.put(runnable,i*1000);
        }
    }
}
