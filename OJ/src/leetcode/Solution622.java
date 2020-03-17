package leetcode;

import java.util.List;
import java.util.Queue;

/**
 * 设计循环队列
 */
public class Solution622 {

    private int[] arr;
    private int front;
    private int rear;

    public Solution622(int k) {
        arr = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(this.isFull()){
            return false;
        }
        this.arr[rear] = value;
        this.rear = (this.rear+1 )% this.arr.length;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(this.isEmpty()){
            return false;
        }
        this.front = (this.front+1 )% this.arr.length;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(this.isEmpty()){
            return -1;
        }
        return this.arr[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(this.isEmpty()){
            return -1;
        }
        if(this.rear == 0){
            return this.arr[arr.length-1];
        }
        return this.arr[rear-1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(this.rear == this.front ){
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if((this.rear+1)%this.arr.length == this.front){
            return true;
        }
        return false;
    }

}
