import java.util.Stack;

public class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 输入的表达式的括号是否能配对
     * @param statement string字符串
     * @return bool布尔型
     */
    public static boolean isValid (String statement) {
        // write code here
        if(statement == null || statement.equals("")){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < statement.length(); j++) {
            char temp2 = statement.charAt(j);
            if(temp2 == '(' || temp2 == ')' || temp2 == '[' || temp2 == ']' || temp2 == '{' || temp2 == '}') {
                if (temp2 == '(' || temp2 == '[' || temp2 == '{') {
                    stack.push(temp2);
                    continue;
                }
                if ((temp2 == ')'&& stack.peek()=='(') || (temp2 == ']'&& stack.peek()=='[') || (temp2 == '}'&& stack.peek()=='{')) {
                    if (stack.size() > 0) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if(stack.size() == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("[(123)"));
    }
}
