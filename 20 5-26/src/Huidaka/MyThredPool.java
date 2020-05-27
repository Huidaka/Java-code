package Huidaka;

import com.sun.corba.se.impl.ior.WireObjectKeyTemplate;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MyThredPool {
    //保存待执行的任务
    private BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
    private int maxThread = 10;
    private Worker workers[] = new Worker[maxThread];

    class Worker extends Thread{
        @Override
        public void run() {
            Runnable command = null;
            while (true) {
                try {
                    synchronized (this) {
                        command = queue.take();
                    }
                    command.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void execute(Runnable command) throws InterruptedException {
        int i = 0;
        if( i < maxThread){
            Worker worker = new Worker();
            worker.start();
            workers[i++] = worker;
            System.out.println("线程");
        }
        queue.put(command);
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
