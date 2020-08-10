package Huidaka;

import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
    }

    public static void quick(int[] array, int left, int right){
        if(left >= right){
            return;
        }
        int pivot = partion3(array,left,right);
        quick(array,left,pivot-1);
        quick(array,pivot+1,right);
    }

    public static int partion(int[] array, int left, int right){
        int temp = array[left];
        while (left < right){
            while (left<right && array[right]>temp){
                right--;
            }
            array[left] = array[right];
            while (left<right && array[left]<temp){
                left++;
            }
            array[right] = array[left];
        }
        array[left] = temp;
        return left;
    }k

    public static int partion2(int[] array, int left, int right){
        Random random = new Random();
        int index = random.nextInt(right+1);
        int temp = array[index];
        while (left < right){
            while (left<right && array[right]>temp){
                right--;
            }
            while (left<right && array[left]<temp){
                left++;
            }
            int flag = array[left];
            array[left] = array[right];
            array[right] = flag;
        }
        return left;
    }

    public static int partion3(int[] array, int left, int right){
        Random random = new Random();
        int index = select(array,left,right);
        int temp = array[index];
        while (left < right){
            while (left<right && array[right]>temp){
                right--;
            }
            while (left<right && array[left]<temp){
                left++;
            }
            int flag = array[left];
            array[left] = array[right];
            array[right] = flag;
        }
        return left;
    }

    public static int select(int[] array, int left, int right){
        int mid = (left + right) >>> 1;
        if (array[left] > array[mid]){
            swap(array,left,mid);
        }
        if (array[left] > array[right]) {
            swap(array,left,right);
        }
        if(array[mid] > array[right]){
            swap(array,mid,right);
        }
        return mid;
    }

    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        int[] array = {9,5,21,32,100};
        quickSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        Random random = new Random();
    }
}
