package cn.Huidaka;

import java.util.Scanner;

//class Test1{
//    final void print(){
//        System.out.println("hahaha");
//    }
//}
//public class Test extends Test1{
//    public static void main(String[] args) {
//
//    }
//    final void print(){
//        System.out.println("hahaha");
//    }
//}
//final class Test1{
//    public void print() {
//
//    }
//}
//public final class Test extends Test1{
//    public static void main(String[] args) {
//
//    }
//}
class Test{
    public static void main(String[] args) {
        int[] h = new int[6];
        int l;
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for(int j = 1; j <= m; j++) {
            for (int i = 0; i < h.length; i++) {
                h[i] = (int) (Math.random() * 32 + 1);
            }
            l = (int) (Math.random() * 32 + 1);
            for (int i = 0; i < h.length; i++) {
                System.out.printf("%-3d",h[i]);
            }
            System.out.println(" ("+l+")");
        }
    }
}
