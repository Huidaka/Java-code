import java.util.Scanner;
import java.util.Stack;k

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String string = sc.nextLine();
            System.out.println(isStringValid(string));
        }
    }

    public static boolean isStringValid(String s){
        if(s.equals("") || s == null){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char temp = s.charAt(i);
            if(temp==('(') || temp==('[') || temp==('{')){
                stack.push(temp);
            }
            else{
                if(stack.size()==0){
                    return false;
                }
                char peek = stack.peek();
                if(temp==(')') && peek==('(') || temp==(']') && peek==('[') || temp==('}') && peek==('{')){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
