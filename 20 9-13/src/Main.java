import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 找出出现ip最多次数
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int strlen = scanner.nextInt();
        scanner.nextLine();
        Set<String> set = new HashSet<>();
        String[] strings = new String[len];
        for (int i = 0; i < len; i++) {
            strings[i] = scanner.nextLine();
            set.add(strings[i]);
        }
        for (int k = 0; k < set.size(); k++) {
            System.out.println(strings[k]);
        }
    }
}
