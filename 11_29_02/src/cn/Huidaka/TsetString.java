package cn.Huidaka;

public class TsetString {
    public static void main(String[] args) {
        String str1 = "hahaha";//直接在常量池里创建一个对象
        String str2 = "hahaha";
        String str3 = "hehehe";
        String str4 = new String("hahaha");//创建一个对象
        System.out.println(str1 == str2);//true  //因为字符串是不可变的，所以常量池池中的字符串是唯一的
        str3 = "hahaha";
        System.out.println(str3 == str2);//true
        System.out.println(str4 == str3);//flase,当改变str的值的时候并不是直接new了一个新对象，而是先看常量池中有没有这个字符串如果有直接引用
        str2 = "lueluelue";              //如果没有才会在常量池里new一个对象
        String str5 = new String("lueluelue");//创建两个对象
        System.out.println(str4 == str1);//false
    }
}
