package cn.Huidaka;

//实现字符串的相关操作

import java.util.Arrays;

public class MyString {
    public static void main(String[] args) {
        String str = "abcdefg";
        char a = str.charAt(1);   //取得指定位置索引字符
        System.out.println(a);
        char[] chars = str.toCharArray();  //字符串转字符数组
        System.out.println(chars);
    }
}
