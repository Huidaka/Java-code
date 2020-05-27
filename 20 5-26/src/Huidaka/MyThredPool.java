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
    private Worker workers[] = null;

    class Worker extends Thread{
        @Override
        public void run() {
            Runnable command = null;
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

    public void execute(Runnable command){
        if(maxThread < 10){
            Worker worker = new Worker();
            worker.start();
        }
    }

}
