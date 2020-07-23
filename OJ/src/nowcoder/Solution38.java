package nowcoder;
/**
 * 石头剪刀布游戏
 */

import java.util.Scanner;
public class Solution38 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] j = new int[3];
        int[] y = new int[3];
        int jvictory = 0;
        int jdraw = 0;
        for(int i=0; i<n; i++){
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            int ret = jugement(strs[0],strs[1],j,y);
            if(ret == 1){
                jvictory++;
            }
            if(ret == 0){
                jdraw++;
            }
        }
        System.out.println(jvictory + " " + jdraw + " " + (n-(jvictory + jdraw)));
        System.out.println((n-(jvictory + jdraw)) + " " + jdraw + " " + jvictory);
        System.out.print(maxCount(j) + " " + maxCount(y));
    }
    private static int jugement(String str1, String str2, int[] j, int[] y){
        if(str1.equals(str2)){
            return 0;
        }
        if(str1.equals("C") && str2.equals("J")){
            j[1]++;
            return 1;
        }
        else if(str1.equals("B") && str2.equals("C")){
            j[0]++;
            return 1;
        }
        else if(str1.equals("J") && str2.equals("B")){
            j[2]++;
            return 1;
        }
        else{
            if(str2.equals("C")){
                y[1]++;
            }
            if(str2.equals("J")){
                y[2]++;
            }
            if(str2.equals("B")){
                y[0]++;
            }
            return -1;
        }
    }
    private static String maxCount(int[] arr){
        if(arr[0]>=arr[1] && arr[0]>=arr[2]){
            return "B";
        }
        if(arr[1]>=arr[0] && arr[1]>=arr[2]){
            return "C";
        }
        if(arr[2]>=arr[1] && arr[2]>=arr[0]){
            return "J";
        }
        return null;
    }
}