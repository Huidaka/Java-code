package cn.Huidaka;

import java.util.Scanner;

class StringPealaceTest {
    public static void main(String[] args) {
        String str;
        Scanner s = new Scanner(System.in);
        str = s.nextLine();
        StringPealace stringPealace = new StringPealace();
        String str1 = stringPealace.stringPealace(str);
        System.out.println(str1);
    }
}