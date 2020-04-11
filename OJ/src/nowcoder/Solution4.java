package nowcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *坏键盘
 */
public class Solution4{
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        String except = scan.nextLine();
        String act = scan.nextLine();
        Set<Character> setAct = new HashSet<>() ;
        for(char actChar : act.toUpperCase().toCharArray()) {
            setAct.add(actChar);
        }
        Set<Character> setBroken = new HashSet<>();
        for(char exceptChar : except.toUpperCase().toCharArray()){
            if( !setAct.contains(exceptChar) && !setBroken.contains(exceptChar)){
                setBroken.add (exceptChar);
                System.out.print(exceptChar);
            }
        }
    }
}
