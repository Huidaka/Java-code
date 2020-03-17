package leetcode;

import java.util.Stack;

/**
 * 实现最小栈，即在常数时间内检索出栈中最小的元素
 */
public class Solution155 {
    private Stack<Integer> sta1;
    private Stack<Integer> sta2;

    /** initialize your data structure here. */
    public Solution155() {
        this.sta1 = new Stack<>();
        this.sta2 = new Stack<>();
    }

    public void push(int x) {
        sta1.push(x);
        if(this.sta2.empty() ||x <= this.sta2.peek()){
            this.sta2.push(x);
        }
    }

    public void pop() {
        if(this.sta1.empty()){
            return;
        }
        int temp = this.sta1.pop();
        if(this.sta2.peek() == temp){
            sta2.pop();
        }
    }

    public int top() {
        return sta1.peek();
    }

    public int getMin() {
        return sta2.peek();
    }
}
