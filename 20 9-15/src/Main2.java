import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        StringBuffer retString = new StringBuffer("");
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            char temp = string.charAt(i);
            if(!set.contains(temp)){
                retString.append(temp);
            }
            set.add(string.charAt(i));
        }
        System.out.println(String.valueOf(retString));
    }
}
