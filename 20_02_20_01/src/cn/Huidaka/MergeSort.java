package cn.Huidaka;

public class MergeSort {


    boolean testTergeSort(int a[], int n) {
        int[] p = new int[n];
        if (p == null)
            return false;
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

}
