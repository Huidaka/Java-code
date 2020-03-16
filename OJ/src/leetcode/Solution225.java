package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 队列实现栈
 */
public class Solution225 {
    private Queue<Integer> qu1;
    private Queue<Integer> qu2;
    private int usedSize;

    /** Initialize your data structure here. */
    public Solution225() {
        this.qu1 = new LinkedList<>();
        this.qu2 = new LinkedList<>();
        this.usedSize = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if( !this.qu1.isEmpty()) {
            this.qu1.offer(x);
        }
        else if(!this.qu2.isEmpty()){
            this.qu2.offer(x);
        }
        else{
            this.qu1.offer(x);
        }
        this.usedSize++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(this.empty()){
            throw new RuntimeException("空栈");
        }
        int temp = 0;
        if(!this.qu1.isEmpty()){
            for (int i = 0; i < this.usedSize-1; i++) {
                this.qu2.offer(this.qu1.poll());
            }
            temp = qu1.poll();
        }
        else{
            for (int i = 0; i < this.usedSize-1; i++) {
                this.qu1.offer(this.qu2.poll());
            }
            temp = qu2.poll();
        }
        this.usedSize--;
        return temp;
    }

    /** Get the top element. */
    public int top() {
        if(this.empty()){
            throw new RuntimeException("空栈");
        }
        int temp = 0;
        if(!this.qu1.isEmpty()){
            for (int i = 0; i < this.usedSize-1; i++) {
                this.qu2.offer(this.qu1.poll());
            }
            temp = this.qu1.poll();
            this.qu2.offer(temp);
        }
        else{
            for (int i = 0; i < this.usedSize-1; i++) {
                this.qu1.offer(this.qu2.poll());
            }
            temp = this.qu2.poll();
            this.qu1.offer(temp);
        }
        return temp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(qu1.isEmpty() && qu2.isEmpty()){
            return true;
        }
        else {
            return false;
        }

    }

    public static void main(String[] args) {
        Solution225 obj = new Solution225();
        obj.push(5);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
    }
}

