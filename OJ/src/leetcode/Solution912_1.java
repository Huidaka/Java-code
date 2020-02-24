package leetcode;

//归并排序数组

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class Solution912_1{

    boolean testmergeSort(int a[], int n) {
        int[] p = new int[n];
        mergeSort(a, 0, n - 1, p);
        return true;
    }
    public  void mergeSort(int a[] , int first,  int last, int[] temp){
        if(first == last){

        }
        else{
            int mid = (first + last)/2;
            mergeSort(a,first,mid,temp);
            mergeSort(a,mid+1,last,temp);
            mergeArray(a,first,mid,last, temp);
        }
    }

    private void mergeArray(int a[], int first, int mid, int last, int temp[]){
        int i = first; int j = mid+1;
        int m = mid;   int n = last;
        int k = 0;
        while (i<=m && j<=n){
            if(a[i] < a[j]){
                temp[k++] = a[i++];
            }
            else{
                temp[k++] = a[j++];
            }
        }
        while(i <= m){
            temp[k++] = a[i++];
        }
        while(j < n){
            temp[k++] = a[j++];
        }
        for (int l = 0; l < k; l++) {
            a[first+l] = temp[l];
        }
    }

    public static void main(String[] args) {
        Solution148_2 solution148_2 = new Solution148_2();
        int a[] = new int[]{45,65,45,4832,414,112,145};
        solution148_2.testmergeSort(a,a.length);
        System.out.println(Arrays.toString(a));
    }
}
