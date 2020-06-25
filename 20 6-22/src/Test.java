import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 生成括号序列
 */
public class Test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        createBracket(new char[n*2],list,0);
        for (String s: list) {
            System.out.println(s);
        }
    }

    /**
     * 生成2^2n个括号序列
     * @param chars
     * @param list
     * @param n
     */
    public static void createBracket(char[] chars,List<String> list , int n){
        if(n == chars.length){
            if(isValid(chars)){
                list.add(new String(chars));
            }
        }
        else {
            chars[n] = '(';
            createBracket(chars, list, n + 1);
            chars[n] = ')';
            createBracket(chars, list, n + 1);
        }
    }

    /**
     * 判断括号序列是否合法
     * @param chars
     * @return
     */
    public static boolean isValid(char[] chars){
        int flag = 0;
        for(char c : chars){
            if(c == '(') flag++;
            if(c == ')') flag--;
            if(flag < 0){
                return false;
            }
        }
        return flag == 0;
    }
}
