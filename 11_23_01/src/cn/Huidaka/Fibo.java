package cn.Huidaka;

public class Fibo {
        public static void main(String[] args){
            int n = 10;
            System.out.println(fibo(n));
        }
        public static int fibo(int n){
            if(n == 1){
                return 1;
            }
            else if(n ==2){
                return 1;
            }
            else{
                return fibo(n-1) + fibo(n-2);
            }
        }
}
