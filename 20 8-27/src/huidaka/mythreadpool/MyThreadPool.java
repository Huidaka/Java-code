package huidaka.mythreadpool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 简易线程池
 */
public class MyThreadPool {
        //保存任务的阻塞队列
        private BlockingQueue<Runnable> queue = new LinkedBlockingDeque();
        //代表最大的线程数
        private static int maxThread = 0;
        //存放线程的线程链表
        List<Work> works = new LinkedList<>();

        //执行任务的线程类
        class Work extends Thread{
            @Override
            public void run() {
                Runnable command = null;
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        command = queue.take();
                        command.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void execute(Runnable command){
            if(maxThread < 10){
                Work work = new Work();
                work.start();
                works.add(work);
                maxThread++;
            }
            try {
                queue.put(command);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void shutDown(){
            for (Work work  : works) {
                work.interrupt();
            }
            for (Work work : works){
                try {
                    work.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("哈哈哈");
            }
        };
        MyThreadPool myThreadPool = new MyThreadPool();
        myThreadPool.execute(runnable);
    }
}
