package Huidaka;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 实现顺序栈
 * @param <E>
 */
public class MyStack1<E> {
     private E[] e;
     private int usedSize = 0;

     public MyStack1() {
          this.e = (E[]) new Object[10];
          this.usedSize = 0;
     }

     /**
      * 压栈
      * @return
      */
     public void push(E val) {
          if(isFull()){
               return;
          }
          this.e[this.usedSize] = val;
          this.usedSize++;
     }

     /**
      *  出栈：返回值是出栈的元素
      * @return
      */
     public E pop(){
          if(this.empty()){
               return null;
          }
          E data = this.e[this.usedSize-1];
          this.usedSize--;
          return data;
     }

     /**
      * 得到栈顶元素但是不出栈
      * @return
      */
     public E peek(){
          if(this.empty()){
               return null;
          }
          return this.e[this.usedSize-1];
     }
     /**
      * 测试堆栈是否为空
      * @return
      */
     public boolean empty(){
          if(this.usedSize == 0){
               return true;
          }
          return false;
     }

     /**
      * 判断堆栈是否满
       * @return
      */
     public boolean isFull(){
          if(this.usedSize == this.e.length){
               return true;
          }
          return false;
     }

}
