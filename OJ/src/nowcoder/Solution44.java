package nowcoder;
/**
 * 字母统计
 */

import java.util.HashMap;
import java.util.Scanner;
public class Solution44{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] strs = str.split("");
            HashMap<String,Integer> map = new HashMap<>();
            //将所有字符统计放入map中
            for (int i = 0; i < strs.length; i++) {
                map.put(strs[i],map.getOrDefault(strs[i],0)+1);
            }
            //存放26个大写字母
            char[] chars = new char[26];
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) (i+65);
            }
            //根据存放得26个字母去map中寻找出现得次数
            for (int i = 65; i <= 90; i++) {
                System.out.printf("%c:%d\n",i,map.getOrDefault(String.valueOf(chars[i-65]),0));
            }
        }
    }
}