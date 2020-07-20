package nowcoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 对大整数进行排序
 */
public class Solution33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> list = new ArrayList<String>(n);
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    for(int i = 0; i<o1.length(); i++){
                        char c1 = o1.charAt(i);
                        char c2 = o2.charAt(i);
                        if(c1 != c2){
                            return c1-c2;
                        }
                    }
                }
                return o1.length()-o2.length();
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(list.get(i));
        }
    }
}
