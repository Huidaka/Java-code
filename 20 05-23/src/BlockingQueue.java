public class BlockingQueue {
    private static int[] arr = new int[50];
    private static volatile int size = 0;
    private static volatile int head = 0;
    private static volatile int tial = 0;

    public void offer(int value) throws InterruptedException {
        synchronized (this) {
            while(size == arr.length){
                wait();
            }
            arr[tial++] = value;
            if(tial == arr.length){
                tial = 0;
            }
            size++;
            notify();
        }
    }

    public int pull() throws InterruptedException {
        int ret = 0;

        synchronized (this) {
            while(size == 0){
                wait();
            }
            ret = arr[head++];
            if(head == arr.length){
                head = 0;
            }
            size--;
            notify();
            return ret;
        }

    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();
        Thread consumer = new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        int n = blockingQueue.pull();
                        System.out.println("消费者："+n);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread producer = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        blockingQueue.offer(i);
                        System.out.println("生产者："+i);
                        sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        consumer.start();
        producer.start();
    }
}