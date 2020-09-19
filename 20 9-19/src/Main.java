import java.util.Scanner;

/**
 * 正则表达式匹配
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();
        int i = 0 ,j = 0;
        for (; i < p.length();i++,j++) {
            if(s.charAt(i) != p.charAt(j)){
                if(p.charAt(j) == '.');
                else if(p.charAt(j) == '*' || p.charAt(j) == '+'){
                    while (p.charAt(j+1) != s.charAt(i)){
                        if(i >= s.length()){
                            System.out.println("false");
                            return;
                        }
                        i++;
                    }
                }
                else {
                    System.out.println("false");
                    return;
                }
            }
        }
        if(i == s.length() && j == p.length()-1){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
