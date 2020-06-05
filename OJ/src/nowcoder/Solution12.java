package nowcoder;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class Solution12 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return -1;
            }
            while (!stack1.empty()) {
                int temp = stack1.pop();
                stack2.push(temp);
            }
            return stack2.pop();
        }
        else{
            return stack2.pop();
        }
    }
}