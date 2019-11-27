package cn.Huidaka;

import java.text.BreakIterator;
import java.util.Scanner;

public class StringCharCombination {
    static int j = 0;
    public static void main(String[] args) {
        int k = 0;
        Scanner sc = new Scanner(System.in);
        char[] str = sc.nextLine().toCharArray();   //创建字符串数组
        String[] s = new String[100];
        int len = str.length;  //求出字符串长度，作为参数传递控制循环次数
        if (len == 0)
            return;  //当输入为空时，直接返回
        Permutations(s, str, 0, len);
        for(int i=0;i<j;i++){
            for(k=i+1; k<j;k++) {
                if(s[i].equals(s[k])){
                    break;
                }
            }
            if(k == j) {
                System.out.println(s[i]);//剔除重复的字符串
            }
        }
    }
    //递归函数
    public static void Permutations(String[] s, char[] str, int index, int len) {
        //当索引指向字符串尾部时，将str压入数组   
        if (index == len) {
            s[j] = String.valueOf(str);
            j++;
            return;
        }
        for (int i = index; i < len; ++i) {
            if (i != index && str[i] == str[index]) {
                continue;
            }// 保证当输入多个重复字符时，不会重复计算
            char a = str[i];
            str[i] = str[index];
            str[index] = a;
            Permutations(s, str, index + 1, len);
            a = str[index];
            str[index] = str[i];
            str[i] = a;
        }
    }
}

