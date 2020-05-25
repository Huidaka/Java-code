import java.time.temporal.Temporal;
import java.util.concurrent.PriorityBlockingQueue;

public class Timer {
    //创建一个优先级阻塞队列,用来存放待执行的任务
    private static PriorityBlockingQueue<Task> pr = new PriorityBlockingQueue<>();
    //任务类，用来描述任务的执行时间和，执行内容
    static class Task implements Comparable<Task>{
        private Runnable command;
        private long time;

        public Task(Runnable command, long time) {
            this.command = command;
            this.time = time + System.currentTimeMillis();
        }

        public void run(){
            command.run();
        }

        @Override  //时间作为优先级对列的优先度比较基准
        public int compareTo(Task o) {
            return (int)(this.time - o.time);
        }
    }
    //向定时器中添加待处理任务
    public void insert(Runnable runnable , long time){
        Task task = new Task(runnable,time);
        pr.put(task);
        System.out.println("开始计时：");
        synchronized (this) {
            notify();  //唤醒扫描线程，防止新加入的任务优先度高于原本最高优先度任务
        }
    }
    //扫描器
    static class Work extends Thread{
        @Override
        public void run() {
            while(true){
                try {
                    Task task = pr.take();
                    long time  = System.currentTimeMillis();
                    if(task.time > time){
                        pr.put(task);
                        synchronized (this) {
                            wait(task.time - time);
                        }
                    }
                    else{
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    public Timer() {
        Work work = new Work();
        work.start();
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("闹钟响了");
                timer.insert(this,3000);
            }
        };
        timer.insert(r,3000);
    }
}
//wait()和notify()方法优化扫描器的运行，防止扫描器进行无意义扫描
