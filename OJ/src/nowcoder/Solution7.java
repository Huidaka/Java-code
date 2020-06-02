package nowcoder;
/**
 * 换汽水瓶
 */

import java.util.Scanner;

public class Solution7 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            if(n == 0){
                return;
            }
            System.out.println(n/2);
        }
    }
}
