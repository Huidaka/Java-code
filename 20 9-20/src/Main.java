import java.util.Scanner;

/**
 * 解码
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        StringBuffer ret = new StringBuffer();
        int k = 0;
        func(string,0,ret);
        System.out.println(ret);
    }
    public static int func(String string,Integer i,StringBuffer temp){
        StringBuffer stringBuffer = new StringBuffer();
        int k = i-2<0 ? 0 : string.charAt(i-2) - '0';
        while (i < string.length() && string.charAt(i) != ']') {
            int n = string.charAt(i) - '0';
            if (n > 0 && n <= 9) {
                if (string.charAt(i+1) == '[') {
                    i = func(string, i+2, stringBuffer) + 1;
                    temp.append(stringBuffer);
                }
                for (int j = 0; j < k-1; j++) {
                    temp.append(temp);
                }
            }
            else {
                temp.append(string.charAt(i++));
            }
        }
        return i;
    }
}
