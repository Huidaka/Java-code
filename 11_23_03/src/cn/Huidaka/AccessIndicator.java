package cn.Huidaka;

public class AccessIndicator {
    public static void main(String[] args){
        int m = Dinner.i;        //不可以创建对象时，可以访问包访问权限类里面的public static成员。
        //int v = Dinner.n;      不可以创建对象时，不可以访问包访问权限类里面的public成员
        Dinner d = new Dinner(); //包访问权限可以创建对象,把构建器设成private后，无法实例化创建对象
        m =  d.s;                //private可以被
        m = d.n;
        //! m = d.f;  Error:(9, 13) java: f 在 cn.Huidaka.Dinner 中是 private 访问控制
    }
}
