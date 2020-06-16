package nowcoder;

import java.util.Scanner;

/**
 * 组个最小数
 */
public class Solution27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int[] arr = new int[10];
            StringBuilder str = new StringBuilder("");
            for(int i = 0; i<10; i++){
                arr[i] = sc.nextInt();
                for(int j = 0; j<arr[i]; j++){
                    str.append(i);
                }
            }
            if(arr[0] != 0){
                String str0 = str.substring(0,arr[0]);
                str = new StringBuilder(str.substring(arr[0],str.length()));
                str= str.insert(1,str0);
                System.out.println(str.toString());
            }
            else{
                System.out.println(str.toString());
            }
        }
    }
}
