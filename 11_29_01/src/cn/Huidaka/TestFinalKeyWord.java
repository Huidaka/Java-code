package cn.Huidaka;
final class Test1{
      int i = 1;
      final int i2 = 0;//final修饰的类变量还是在栈上储存，并且与对象强相关。
      String str = new String("hahaha") ;
}

class  Test2{
    final Test1 t1 = new Test1();
    final Test1 t2;
    Test2() {
        t2 = new Test1();//final修饰对象句柄的时候要不定义句柄的时候实例化，要不构建器里面实例化，否则编辑器会报错；
    }

}
public class TestFinalKeyWord {//测试final关键字。

    public static void main(String[] args) {
        final int i = 1;
        //! i = 10;     final修饰变量的时候表示这个变量是常变量，不能在改变
        final Test1 t1 = new Test1();
        //！ t1 = new Test1();  final修饰的对象句柄不能在指向其他对象；
        t1.i = 10;//虽然对象的引用不能在改变，但是对象的内容可以改变。
        System.out.println(t1.i);//10
        final int[] arr = {1,2,3,4,5};
        //! arr = new int[]{2};   //final修饰数组的时候也是数组的引用不能改变，但是数组的内容可以改变。
        arr[0] = 100;
        System.out.println(arr[0]);//100
        Test2 t2 = new Test2();
        System.out.println(t2.t1.str);
    }
}
//在类中声明常量通常用static，final组合使用。