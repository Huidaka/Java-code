package leetcode;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class Solution232 {
    private Stack<Integer> sta1;
    private Stack<Integer> sta2;

    public Solution232() {
        this.sta1 = new Stack<>();
        this.sta2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        sta1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(this.empty()){
            throw new RuntimeException("空栈 ");
        }
        if(!this.sta2.empty()){
            return this.sta2.pop();
        }
        else{
            while(!this.sta1.empty()){
                this.sta2.push(this.sta1.pop());
            }
            return this.sta2.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if(this.empty()){
            throw new RuntimeException("空栈 ");
        }
        if(!this.sta2.empty()){
            return this.sta2.peek();
        }
        else{
            while(!this.sta1.empty()){
                this.sta2.push(this.sta1.pop());
            }
            return this.sta2.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(this.sta1.empty() && this.sta2.empty()){
            return true;
        }
        return false;
    }
}
