package huidaka.storage;

public class CycleQueue<T> {
    public T[] array;
    public int size;
    public int frontIndex;
    public int rearIndex;

    public CycleQueue(int capacity) {
        this.array = (T[])new Object[capacity];
        this.size = 0;
        this.frontIndex = 0;
        this.rearIndex = 0;
    }

    public synchronized void  push(T value){
        array[rearIndex] = value;
        rearIndex = (rearIndex +1) % array.length;
        if(size == array.length){
            frontIndex = rearIndex;
        }
        else {
            size++;
        }
    }

    public synchronized  T pop(){
        if(size != 0){
            T ret = array[frontIndex];
            frontIndex = (frontIndex+1) % array.length;
            size--;
            return ret;
        }
        else{
            throw new RuntimeException("队列为空");
        }
    }
}
