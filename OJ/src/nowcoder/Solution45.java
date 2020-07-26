package nowcoder;
/**
 * 进制转换
 */

import java.util.HashMap;
import java.util.Scanner;

public class Solution45 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String,Integer> map = new HashMap();
        for(int i=0; i<16; i++){
            if(i<=9){
                String temp = String.valueOf(i);
                map.put(temp,i);
            }
            else{
                String temp = String.valueOf((char)(i+55));
                map.put(temp,i);
            }
        }
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] strs = str.split("");
            int sum = 0;
            int j = 0;
            for(int i=strs.length-1; i>=0;i--){
                if(strs[i].equals("x")){
                    break;
                }
                sum += map.get(strs[i])*Math.pow(16,j++);
            }
            System.out.println(sum);
        }
    }
}
