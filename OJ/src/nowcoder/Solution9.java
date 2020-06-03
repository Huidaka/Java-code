package nowcoder;

import java.util.Stack;

/**
 * 判断一个字符串是不是一个合格的括号串
 */
public class Solution9 {
    public boolean chkParenthesis(String A, int n) {
        if(n%2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i<A.length(); i++){
            if(A.charAt(i) == '(' || A.charAt(i) == ')'){
                if(A.charAt(i) == '('){
                    stack.push('(');
                }
                else{
                    stack.pop();
                }
            }
            else{
                return false;
            }
        }
        if(stack.empty()){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        System.out.println(solution9.chkParenthesis("(()a())",7));
    }
}
