import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        String[] strings = new String[]{"ABCDEFGHI","JKLMNOPQR","STUVWXYZ*"};
        Scanner sc = new Scanner(System.in);
        int mounth = sc.nextInt();
        int day = sc.nextInt();
        sc.nextLine();
        String message = sc.nextLine().replaceAll(" ","*");
        String[] encoding = characterEncoding(strings,mounth,day);
        for (int i = 0; i < message.length(); i++) {
            char temp = message.charAt(i);
            int[] ret = retCharIndex(temp,encoding);
            System.out.print(ret[0] + "" + ret[1] + " ");
        }
    }

    private static String[] characterEncoding(String[] strings, int mounth,int day){
        int index1 = 0,index2 = 1,index3 = 2;
        int len = strings.length;
        String[] ret = Arrays.copyOf(strings,strings.length);
        if(mounth>1){
            index1 = -(mounth-1) >= 0 ? -(mounth-1) : len+(-(mounth-1));
            index2 = 1-(mounth-1) >= 0 ? 1-(mounth-1) : len+(1-(mounth-1));
            index3 = 2-(mounth-1) >= 0 ? 2-(mounth-1) : len+(2-(mounth-1));
            ret[index1] = strings[0];
            ret[index2] = strings[1];
            ret[index3] = strings[2];
        }
        if(day > 1){
            int[] index = new int[9];
            for (int i = 0; i < 3; i++) {
                StringBuffer temp = new StringBuffer("000000000");
                for (int j = 0; j < 9; j++) {
                    index[j] = j-((day-1)%9) >= 0 ? j-((day-1)%9) : 9+(j-(day-1)%9);
                    temp.setCharAt(index[j],ret[i].charAt(j));
                }
                ret[i] = String.valueOf(temp);
            }
        }
        return ret;
    }

    private static int[] retCharIndex(char c,String[] strings){
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length(); j++) {
                if(c == strings[i].charAt(j)){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[0];
    }
}
