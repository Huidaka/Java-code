package cn.Huidaka;

public class TestValuePropagation {
    public static void main(String[] args){
        int m = 10;
        int n = 20;
        swap1(m,n);
        System.out.println("main:"+m+" "+n);
    }
    public static void swap1(int m, int n){
        int tmp = 0;
        tmp = m;
        m = n;
        n = tmp;
        System.out.println("swap1:"+m+" "+n);
    }
}//运行结果：
//swap1:20 10
//main:10 20
 class TestValuePropagation2 {
    public static void main(String[] args) {
        B b1 = new B();
        testQuote(b1);
        System.out.println("a:" + b1.a);
    }

    public static void testQuote(B b) {
        b.a = 200;
    }

}
class B {
    int a = 100;
}//运行结果
//a:200
class TestValuePropagation3 {
    public static void main(String[] args) {
        B b2 = new B();
        testQuote(b2);
        System.out.println("a:" + b2.a);
    }

    public static void testQuote(B b) {
        b = new B();
        b.a = 200;
        System.out.println("a:" + b.a);
    }
    //运行结果
    //a:200
    //a:100
}
class TestValuePropagation4 {
    public static void main(String[] args) {
        String str = "hahaha";
        testQuote(str);
        System.out.println("main()str:" + str);
    }

    public static void testQuote(String str) {
        str = "hehehe";
        System.out.println("testQuote()str:" + str);
    }
}
//运行结果
//testQuote()str:hehehe
//main()str:hahaha