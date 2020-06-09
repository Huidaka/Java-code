package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 删数（每隔两个就删一个数，求剩下最后一个数的下标）
 */
public class Solution17 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            List<Integer> list = new ArrayList();
            for(int i = 0; i<n; i++){
                list.add(i);
            }
            int i = 0;
            while(list.size() > 1){
                i = (i + 2)%list.size();
                list.remove(i);
            }
            System.out.println(list.get(0));
        }
    }
}
