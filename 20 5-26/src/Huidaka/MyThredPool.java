package Huidaka;

import com.sun.corba.se.impl.ior.WireObjectKeyTemplate;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MyThredPool {
    //保存待执行的任务
    private BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
    private int maxThread = 10;
    private List<Worker> workers= new LinkedList<>();
    //执行任务的线程类
    class Worker extends Thread{
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
    //添加任务，和线程方法
    public void execute(Runnable command) throws InterruptedException {
        int i = 0;
        if( i < maxThread){ //如果线程数超过设定值，就不再创建新线程，因为线程也不是越多越好
            Worker worker = new Worker(); //因为线程的创建销毁也需要耗费资源
            worker.start();
            workers.add(worker);
            System.out.println("线程");
        }
        queue.put(command);
    }
    //关闭所有线程的方法
    public void shutDown(){
        for(Worker worker : workers){
            worker.interrupt(); //利用中断通知让程序抛出，但是线程也不是立马就销毁的
        }
        for(Worker worker : workers){
            try {
                worker.join();  //标记完之后，线程并不会立马停止运行，需要等待线程都结束，保证shutDown方法执行完毕后，所有线程都通知运行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThredPool myThredPool = new MyThredPool();
        for (int i= 0 ;i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务");
                }
            };
            myThredPool.execute(runnable);
        }
    }

}
