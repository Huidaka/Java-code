package cn.Huidaka;

public class Test {
    public static void main(String[] args) {

        bool MergeSort(int a[], int n)
        {
            int *p = new int[n];
            if (p == NULL)
                return false;
            mergesort(a, 0, n - 1, p);
            delete[] p;
            return true;

        }
}
