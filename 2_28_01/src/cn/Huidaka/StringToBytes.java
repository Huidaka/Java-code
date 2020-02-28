package cn.Huidaka;

//字节常用于数据传输以及编码转换的处理之中，String 也能方便的和 byte[] 相互转换

import java.util.Arrays;

public class StringToBytes {
    public static void main(String[] args) {
        String str = "abcdefg";
        char a = str.charAt(1);   //取得指定位置索引字符
        System.out.println(a);
        char[] chars = str.toCharArray();  //字符串转字符数组
        System.out.println(chars);
    }
}
