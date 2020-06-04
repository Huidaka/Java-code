package nowcoder;


import java.util.Scanner;

/**
 * 瓶子换饮料问题
 */
public class Solution10 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        if(n%2!=0 || n<6 ||n==10) {
            System.out.println(-1);
            return;
        }
        int num1=n/8;
        int num2=n%8;
        if(num2==0){
            System.out.println(num1);
        }
        else {
            System.out.println(num1+1);
        }
    }
      //暴力解法
//    public static void main(String args[]){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        if(n < 6){
//            System.out.println(-1);
//        }
//        for(int i = 0; i <= 16; i++){
//            for(int j = 0; j <= 12; j++){
//                if((i*6 + j*8) > 100){
//                    break;
//                }
//                if((i*6 + j*8) == n){
//                    System.out.println(i+j);
//                    return;
//                }
//            }
//        }
//        System.out.println(-1);
//    }
}
