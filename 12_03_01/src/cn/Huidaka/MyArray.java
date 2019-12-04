package cn.Huidaka;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArray {
    private int data;
    int[] num;
    private int size = 0;

    public MyArray() {
        num = new int[1];
    }

    public MyArray(int m) {
        if(m < 0){
            System.out.println("开辟数组大小输入有误");
        }
        num = new int[m];
    }

    //向动态数组插入元素,默认向数组尾部插入
    public void add(int data){
        if(size == num.length){
            num = Arrays.copyOf(num,size+1);
        }
        num[size++] = data;
    }
    //实现向动态数组任意位置插入元素
    public void add(int intdex,int data){
        if(intdex<0 || intdex > size){
            System.out.println("索引非法");
            return;
        }
        if(intdex == size){
            add(data);
        }
        else {
            num = Arrays.copyOf(num,size+1);
            System.arraycopy(num, intdex, num, intdex + 1, size - intdex);
            num[intdex] = data;
            size++;
        }
    }
    //实现向动态数组删除元素
    public void remove(int intdex){
        if(intdex<0 || intdex >= size){
            System.out.println("索引非法");
            return;
        }
        else{
            System.arraycopy(num,intdex+1,num,intdex,size-intdex-1);
            num = Arrays.copyOf(num,size-1);
            size--;
        }
    }
    //修改数组中的元素
    public void modification(int intdex,int data){
        if(intdex<0 || intdex >= size){
            System.out.println("索引非法");
            return;
        }
        num[intdex] = data;
    }
    //根据索引查找数组中的元素并输出
    public void intdexFindtoNumber(int intdex){
        if(intdex<0 || intdex >= size){
            System.out.println("索引非法");
            return;
        }
        else{
            System.out.println(num[intdex]);
        }
    }
    //根据元素查找数组中的索引并输出
    public void numberFindtointdex(int data){
        for (int i = 0; i < num.length; i++) {
            if(num[i] == data){
                System.out.println("元素下标索引为："+i);
                return;
            }
        }
        System.out.println("数组中没有这个元素");
    }
    //输出数组的每个元素
    public void print(){
        for (int i = 0; i < num.length; i++) {
            if(i == num.length-1){
                System.out.print(num[i]);
            }
            else {
                System.out.print(num[i] + ",");
            }
        }
        System.out.println();
    }
}
