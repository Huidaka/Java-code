package cn.Huidaka;

class Animal{
    protected void heartBart(){
        System.out.println("心跳");
    }
}
//类的组合
class Dog{
    Animal a;
    //! a = new Animal();            //这样写类加载的时候不会实例化对象；想在构建器外面初始化必须加大括号，使用非静态初始化从句
    Dog (){
        System.out.println("Dog()");
        a = new Animal();
    }
    void heartBart(){
        a.heartBart();
    }
    void cry(){
        System.out.println("汪汪汪");
    }
}
//类的继承
class Cat extends Animal{
    Cat(){
        System.out.println("Cat（）");
    }
    void cry(){
        System.out.println("喵喵喵");
    }
}
public class TestInitialize {
    public static void main(String[] args){
        Dog d1 = new Dog();;
        d1.heartBart();
        d1.cry();
        Cat c1 = new Cat();
        c1.cry();
        c1.heartBart();
    }
}

