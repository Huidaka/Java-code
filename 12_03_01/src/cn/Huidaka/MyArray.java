package cn.Huidaka;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArray {
    private int data;
    private int[] num;
    private int size = 0;

    public MyArray() {
        num = new int[1];
    }

    public MyArray(int m) {
        if(m < 0){
            System.out.println("开辟数组大小输入有误");
            return;
        }
        num = new int[m];
    }

    //向动态数组插入元素,默认向数组尾部插入
    public void add(int data){
        if(size == num.length){
            dilatation();
        }
        num[size++] = data;
    }
    //实现向动态数组任意位置插入元素
    public void add(int index,int data){
        if(index<0 || index > size){
            System.out.println("索引非法");
            return;
        }
        if(index == size){
            add(data);
        }
        else {
            dilatation();
            System.arraycopy(num, index, num, index + 1, size - index);
            num[index] = data;
            size++;
        }
    }
    //实现向动态数组删除元素
    public void remove(int index){
        if(index<0 || index >= size){
            System.out.println("索引非法");
            return;
        }
        else{
            System.arraycopy(num,index+1,num,index,size-index-1);
            num = Arrays.copyOf(num,size-1);
            size--;
        }
    }
    //修改数组中的元素
    public void modification(int index,int data){
        if(index<0 || index >= size){
            System.out.println("索引非法");
            return;
        }
        num[index] = data;
    }
    //清空数组的所有方法
    public void full(){
        Arrays.fill(num,0);
    }
    //根据索引查找数组中的元素并输出
    public void intdexFindtoNumber(int index){
        if(index<0 || index >= size){
            System.out.println("索引非法");
            return;
        }
        else{
            System.out.println(num[index]);
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
    //数组扩容
    private void dilatation(){
        num = Arrays.copyOf(num,size+1);
    }
}
