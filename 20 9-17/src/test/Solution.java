package test;

import java.util.Stack;

/**
 * 括号平衡匹配问题
 */
class Solution {
    public static int minInsertions(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(temp == '('){
                stack.push(temp);
            }
            else {
                if (stack.isEmpty()) {
                    count++;
                    stack.push('(');
                }
                if (i < s.length() - 1 && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    count++;
                }
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            return count;
        }
        return stack.size()*2 + count;
    }

    public static void main(String[] args) {
        minInsertions("))())(");
    }
}
