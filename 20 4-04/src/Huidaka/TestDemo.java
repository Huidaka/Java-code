package Huidaka;

import com.sun.tools.javac.Main;

/**
 *实例内部类
 *  A.a test = new A().new a();
 *  实例内部类能定义static类型吗？
 *  不可以 ，如果非要定义就必须定义成static final 类型的
 *  因为static类型是编译期就初始化的，而内部类的初始化在static之后才能初始化，所以内部类的static不可能在内部类初始化之前完成
 */
public class TestDemo {
    int data1 = 10;
    int data2 = 65;
    class InnerClass{
        int data4 = 100;
        void func(){
            System.out.println(data1);
            System.out.println("访问内部类的属性"+data4);
        }
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        TestDemo.InnerClass t = new TestDemo().new InnerClass();
        System.out.println(testDemo.data1);
        System.out.println(testDemo.data2);
        System.out.println(t.data4);
        t.func();
        System.out.println("***********************");
    }
}

/**
 * 静态内部类
 * 相当于一个静态属性
 * 外部类的实例数据成员是不能被访问的，静态的是可以的
 */
class StaticClas{
    int a = 100;
    int b = 99;
    static class InStaticClass{
        int c = 50;
        static int d = 10;
        void test(){
            //System.out.println(b); //静态内容不能访问非静态内容
        }
    }

    public static void main(String[] args) {
        StaticClas.InStaticClass s = new StaticClas.InStaticClass();
        StaticClas staticClas = new StaticClas();
        System.out.println(staticClas.a);
        System.out.println(staticClas.b);
        System.out.println(s.c);
        System.out.println(StaticClas.InStaticClass.d);
    }
}

/**
 * 匿名内部类
 * 相当于外部类的子类
 */
class OutClass{
    void func(){
        System.out.println("hahaha");
    }
}
class test{
    public static void main(String[] args) {
        new OutClass(){
            void func(){
                System.out.println("xixixi");
            }
        }.func();
    }
}
