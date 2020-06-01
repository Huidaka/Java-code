package nowcoder;

/**
 * 第k大数
 */
public class Solution6 {
    public int findKth(int[] a, int n, int K) {
        // write code here
        sort(a,0,n-1);
        return a[n-K];
    }
    public static void sort(int[] array, int left, int right) {
        if(left > right) {
            return;
        }
        int base = array[left];
        int i = left, j = right;
        while(i != j) {
            while(array[j] >= base && i < j) {
                j--;
            }
            while(array[i] <= base && i < j) {
                i++;
            }
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        array[left] = array[i];
        array[i] = base;
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int[] a = new int[]{1,3,5,2,2};
        int n = solution6.findKth(a,5,3);
        System.out.println(n);
    }
}
