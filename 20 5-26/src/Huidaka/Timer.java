package Huidaka;

import sun.font.TrueTypeFont;

import java.util.concurrent.PriorityBlockingQueue;

public class Timer  {
    // 保存待执行任务的优先级阻塞队列
    private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
    //描述任务的类
    class Task implements Comparable<Task>{
        private Runnable command  = null;
        private long time = 0;

        public Task(Runnable command, long time) {
            this.command = command;
            this.time = time + System.currentTimeMillis();
        }
        //执行任务的方法
        public void run(){
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            return (int)(this.time - o.time);
        }
    }
    //创建扫描工具类
    class Worker extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    synchronized (this) {
                        Task task = queue.take();
                        long nowTime = System.currentTimeMillis();
                        if(task.time > nowTime){ //把优先级最高的任务取出来，判断任务是否达到执行条件
                            queue.put(task);     //如果没有就把任务放回去，让扫描等待当前时间和任务执行时间时间差后再次进行判断扫描
                            wait(task.time - nowTime);
                        }
                        else{
                            task.run();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Timer() {
        Worker worker = new Worker();
        worker.start();
    }

    public void insert(Runnable runnable, long time ){
        Task task  = new Task(runnable,time);
        queue.put(task);
        synchronized (this) {
            notify();
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("闹钟响了");
            }
        };
        System.out.println("开始计时：");
        timer.insert(r,3000);
    }
}
