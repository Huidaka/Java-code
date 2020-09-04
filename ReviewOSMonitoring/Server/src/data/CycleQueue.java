package data;

//环形队列
public class CycleQueue<T> {
    public T[] array;
    private int size;
    public int frontIndex;
    public int rearIndex;

    public CycleQueue(int capacity) {
        this.array = (T[])new Object[capacity];
        this.size = 0;
        this.frontIndex = 0;
        this.rearIndex = 0;
    }

    public synchronized void push(T value){
        array[rearIndex] = value;
        rearIndex = (rearIndex + 1)/array.length;
        if(size == array.length){
            frontIndex = rearIndex;
        }
        size++;
    }

    public synchronized T pop(){
        if(size == 0){
            throw new RuntimeException("队列为空");
        }
        T ret = array[frontIndex];
        frontIndex = (frontIndex+1)%array.length;
        return ret;
    }
}
