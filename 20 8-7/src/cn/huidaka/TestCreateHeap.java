package cn.huidaka;

import java.util.Arrays;

public class TestCreateHeap {
    public int[] elem;
    public int usedSize = 0;

    public void createHeap(int[] array){
        this.elem = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        for (int i = (usedSize-1-1)/2; i >= 0; i--) {
            ajustDown(i,usedSize);
        }
    }

    private void ajustDown(int i,int len){
        int parent = i;
        int child = i*2+1;
        while (child < len){
            if((child+1)<len && elem[child] < elem[child+1]){
                child++;
            }
            if(elem[child] > elem[parent]){
                int temp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = temp;
                parent = child;
                child  = child*2+1;
            }
            else{
                break;
            }
        }
    }

    public void push(int value){
        if(usedSize == elem.length) {
            this.elem = Arrays.copyOf(elem,2*elem.length);
        }
        this.elem[usedSize] = value;
        ajustUp(usedSize++);
    }

    private void ajustUp(int i){
        int child = i;
        int parent = (child-1)/2;
        while (child > 0){
            if(this.elem[child] > this.elem[parent]){
                int temp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = temp;
            }
            else {
                break;
            }
            child = parent;
            parent = (parent-1)/2;
        }
    }

    public void show(){
        for (int i = 0; i < usedSize; i++) {
            System.out.print(elem[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {56,544,115,48,15,4,4};
        TestCreateHeap testCreateHeap = new TestCreateHeap();
        testCreateHeap.createHeap(array);
        testCreateHeap.push(200);
        testCreateHeap.show();
    }
}
