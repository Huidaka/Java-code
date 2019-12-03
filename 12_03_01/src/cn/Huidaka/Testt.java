package cn.Huidaka;

public class Testt {
    private int m;
    private int n;
    Testt(int m, int n){
        this.n = n;
        this.m = m;
    }
    public int add(){
        return m+n;
    }
    public static void main(String[] args) {
        Testt test = new Testt(10,20);
        System.out.println(test.add());
    }

}
