package cn.Huidaka;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArray {
    private int data;
    int[] num;
    private int size = 0;
    private int intdex;

    public MyArray() {
        num = new int[10];
    }

    public MyArray(int m) {
        num = new int[m];
    }

    //向动态数组插入元素,默认向数组尾部插入
    public void add(int data){
        if(size == num.length){
            num = Arrays.copyOf(num,size<<1);
        }
        num[size++] = data;
    }
    //实现向动态数组任意位置插入元素
    public void add(int intdex,int data){
        if(intdex == size){
            add(data);
        }
        System.arraycopy(num,intdex,num,intdex+1,size-intdex);
        num[intdex] = data;
    }

}
