package data;

//环形队列
public class CycleQueue<T> {
    public T[] array;
    private int size;
    public int frontIndex;
    public int rearIndex;

    public CycleQueue(int capacity) {
        this.array = (T[])new Object[capacity]; //底层数组初始化
        this.size = 0;
        this.frontIndex = 0;
        this.rearIndex = 0;
    }

    public synchronized void push(T value){
        array[rearIndex] = value;
        rearIndex = (rearIndex + 1)%array.length;   //通过模上数组长度计算rearIndex的下标
        if(size == array.length){
            frontIndex = rearIndex;  //只有当队列放满的时候再添加元素，队列头才会向后移
        }                            //如果队列放满了，就让队列头跟着队列尾往后走
        size++;
    }

    public synchronized T pop() throws RuntimeException{
        if(size == 0){
            throw new RuntimeException("队列为空");
        }
        T ret = array[frontIndex];                   //得到要返回的队头元素数值
        frontIndex = (frontIndex+1)%array.length;   //通过模上数组长度下标计算frontIndex的下标
        size--;
        return ret;
    }
}
