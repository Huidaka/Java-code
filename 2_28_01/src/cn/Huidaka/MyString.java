package cn.Huidaka;

//实现字符串的相关操作

import java.util.Arrays;

public class MyString {
    public static void main(String[] args) {
        //取得指定位置索引字符

        String str = "abcdefg";
        char a = str.charAt(1);
        System.out.println(a);

        //字符串转字符数组
        char[] chars = str.toCharArray();
        System.out.println(chars);

        //实现split方法
        String str1 = "a-b,cd,e-f";
        String[] strs = str1.split("-");
        System.out.println(Arrays.toString(strs));

        String[] strs2 = str1.split("-|,");
        System.out.println(Arrays.toString(strs2));

        String str2 = "name=zhangsan&age=18";
        String[] strs3 = str2.split("&" );
        for (int i = 0; i < strs3.length; i++) {
            String[] temp = strs3[i].split("=");
            System.out.println(temp[0]+"="+temp[1]);
        }

        //实现replace方法
        String str3 = "guoaohui";
        System.out.println(str3.replaceAll("u",","));
        System.out.println(str3.replaceFirst("u",","));

        //实现indexof方法
        String str4 = "jfanaskdfas";
        System.out.println(str4.indexOf("fan"));
        System.out.println(str4.indexOf("as",5));
        System.out.println(str4.lastIndexOf("as"));
        System.out.println(str4.lastIndexOf("as",8));

        //实现contains方法
        String str5 = "huhuhahaha";
        System.out.println(str5.contains("hu"));

        //实现 compareto方法
        String str6 = "huhuhahahah";
        String str7 = "huahahahahah";
        System.out.println(str6.compareTo(str7));
    }

}
