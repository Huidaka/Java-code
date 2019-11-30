package cn.Huidaka;

import java.sql.SQLOutput;

class A{
    static int f = 10;
    int u = 30;
    {
        System.out.println("hahaha");
    }
    static {
        System.out.println("hehehe");
    }
    A(){
        System.out.println("1111111");
    }
   //！ A a = new A();
}
class B{
    static int f = 30;
    B b = new B();
}
class C extends A{
    static int k = 30;
    int h = 20;
    B b;
    C(){
        System.out.println("00000");
    }
}
public class TestClassInitialize {
    public static void main(String[] args) {
        C c1;
        C c2 = new C();//程序会死循环最终栈溢出；因为会先加载父类A；加载类A的时候出
    }
}
//首先会加载类，加载类的时候会先进行装载（先加装载父类），初始化static成员和代码块，然后实例化对象的时候，会先进行类初始化
//类初始化的时候会先初始化变量赋默认值，然后加载构造器，加载构造器会先加载父类的构造器，然后给变量赋值，然后从父类的构造器开始向子类这
//执行