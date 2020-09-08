package leetcode;

import java.util.Scanner;

public class Solution999 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String result = "";
        double resultR = 0;
        int len = str.length();
        for(int i =0 ; i<len; i++){
            for(int j = i+4; j+4<len; j++){
                String tempStr = str.substring(i,j+1);
                double temp = ratio(tempStr);
                if(temp > resultR){
                    result = tempStr;
                    resultR = temp;
                }
            }
        }
        System.out.println(result);
    }
    public static double ratio(String str){
        int count = 0;
        for(int i =0; i<str.length(); i++){
            if(str.charAt(i)== 'G' || str.charAt(i)== 'C'){
                count++;
            }
        }
        return count/(double)str.length() ;
    }
}
