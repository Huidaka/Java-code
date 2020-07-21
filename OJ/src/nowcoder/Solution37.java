package nowcoder;
/**
 * 找出不重复的两个奇数
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            Boolean left = false;
            Boolean right = false;
            for (int j = i-1; j >= 0; j--) {
                if(list.get(j) < list.get(i)){
                    left = true;
                    System.out.print(j + " ");
                    break;
                }
            }
            if(!left){
                System.out.print(-1 + " ");
            }
            for (int k = i+1; k < n; k++) {
                if(list.get(k) < list.get(i)){
                    right = true;
                    System.out.println(k);
                    break;
                }
            }
            if(!right){
                System.out.println(-1);
            }
        }
    }
}
