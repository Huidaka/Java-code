package cn.Huidaka;
import java.util.*;
class InitializeOne{
    public InitializeOne(){
        System.out.println("haha");
    }
    public InitializeOne(String str){
        System.out.println(str);
    }
}
public class Initialize {
    public static void main(String[] args){
        String str = "hehe";
        //InitializeOne t1 = new InitializeOne(str);
        InitializeOne[] t2;//创建属于它的对象句柄的一个数组，但不要实际创建对象并 分配到数组里。
        InitializeOne[] t3 = new InitializeOne[10];//它只是一个句柄数组，并没有实例化创建对象。
        t3[0] = new InitializeOne();//实例化对象
        //t2[1] = new InitializeOne();这句话会报错，数组定义必须确定大小
    }
}
