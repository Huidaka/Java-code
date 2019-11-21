package cn.Huidaka;
import java.util.*;
public class HanNoi {
    static int i = 1;
    public static void main(String[] args){
        int n = 0;
        char a = 'A';
        char b = 'B';
        char c = 'C';
        System.out.println("请输入铜片数");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        hanNoi(n,'A','B','C');
    }
    public static void move(int n, char from, char to){
        System.out.println("第"+i+"步，将"+n+"号铜片从"+from+"——>"+to);
        i++;
    }
    public static void hanNoi(int n,char from, char depened_on, char to){
        if(n == 1){
            move(1,from,to);
            return;
        }
        hanNoi(n-1,from,to,depened_on);
        move(n,from,to);
        hanNoi(n-1,depened_on,from,to);
    }
}
