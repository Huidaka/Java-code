package cn.Huidaka;

class A {
    public A() {
        System.out.println("1.");
    }
    {
        System.out.println("2.");
    }
    static {
        System.out.println("3.");
    }
}
public class B extends A{
    public B() {
        System.out.println("4.");
    }
    {
        System.out.println("5.");
    }
    static {
        System.out.println("6.");
    } // 367215421548
    public static void main(String[] args) {
        System.out.println("7.");
        new B();
        new B();
        System.out.println("8.");
    }
}
