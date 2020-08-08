package Huidaka;
/**
 * 堆排序
 * 
 */
public class HeapSort {
    public void heapSort(int[] array){
        createHeap(array);
        for (int i = 0; i < array.length; i++) {
            swap(array,0,array.length-1-i);
            ajustDown(array,0,array.length-1-i);
        }
    }

    public void swap(int[] array, int i, int j){
        int temp  = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public void createHeap(int[] array){
        int size = array.length;
        for (int i = (size-1-1)/2; i >= 0; i--) {
            ajustDown(array,i,size);
        }
    }

    private void ajustDown(int[] array, int i,int size){
        int parent = i;
        int child = i*2+1;
        while (child < size){
            if((child+1)<size && array[child] < array[child+1]){
                child++;
            }
            if(array[child] > array[parent]){
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;
                parent = child;
                child  = child*2+1;
            }
            else{
                break;
            }
        }
    }
}
