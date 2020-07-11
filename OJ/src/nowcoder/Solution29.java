package nowcoder;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 小红串珠子
 */
public class Solution29{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String strB = sc.nextLine();
        String strH = sc.nextLine();
        int len = strB.length();
        HashMap<Character,Integer> mapB = new HashMap();
        for(int i=0; i<len; i++){
            mapB.put(strB.charAt(i),mapB.getOrDefault(strB.charAt(i),0)+1);
        }
        StringBuilder test = new StringBuilder("");
        for(int j=0; j<strH.length(); j++){
            Character character = strH.charAt(j);
            if(mapB.get(character) != null){
                mapB.put(character,mapB.getOrDefault(character,0)-1);
                len--;
                if(mapB.get(character) == 0){
                    mapB.remove(character);
                }
                test.append(character);
            }
        }
        if(test.length() == strH.length()){
            System.out.println("Yes "+String.valueOf(len));
        }
        else{
            System.out.println("No"+String.valueOf(strH.length()-test.length()));
        }
    }
}
