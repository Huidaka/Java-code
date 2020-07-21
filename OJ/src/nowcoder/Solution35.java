package nowcoder;

import java.util.Scanner;

/**
 * 布雷斯找零钱
 */
public class Solution35 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        String reality = strs[1];
        String standard =  strs[0];
        String[] reNum = reality.split("\\.");
        String[] stNum = standard.split("\\.");
        int num1,num2,num3;
        if(reality.length()>standard.length()){
            int[] ret = func(reNum,stNum);
            System.out.println(ret[0]+"."+ret[1]+"."+ret[2]);
        }
        else if(reality.length()<standard.length()){
            int[] ret = func(stNum,reNum);
            System.out.println("-"+ret[0]+"."+ret[1]+"."+ret[2]);
        }
        else {
            if (reality.compareTo(standard) > 0) {
                int[] ret = func(reNum, stNum);
                System.out.println(ret[0] + "." + ret[1] + "." + ret[2]);
            } else if (reality.compareTo(standard) < 0) {
                int[] ret = func(stNum, reNum);
                System.out.println("-" + ret[0] + "." + ret[1] + "." + ret[2]);
            } else {
                System.out.println("0.0.0");
            }
        }
    }

    public static int[] func(String[] reNum, String[] stNum){
        int[] num = new int[3];
        if(Integer.parseInt(reNum[2]) - Integer.parseInt(stNum[2]) >= 0){
            num[2] = Integer.parseInt(reNum[2]) - Integer.parseInt(stNum[2]);
        }
        else{
            stNum[1] = String.valueOf(Integer.parseInt(reNum[1]) - 1);
            num[2] = Integer.parseInt(reNum[2]) + 19 - Integer.parseInt(stNum[2]);
        }
        if(Integer.parseInt(reNum[1]) - Integer.parseInt(stNum[1]) >= 0){
            num[1] = Integer.parseInt(reNum[1]) - Integer.parseInt(stNum[1]);
        }
        else{
            reNum[0] = String.valueOf(Integer.parseInt(reNum[0]) - 1);
            num[1] = Integer.parseInt(reNum[1]) + 17 - Integer.parseInt(stNum[1]);
        }
        num[0] = Integer.parseInt(reNum[0]) - Integer.parseInt(stNum[0]);
        return num;
    }
}
