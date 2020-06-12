package nowcoder;

/**
 * 构建乘积数组
 */
public class Solution25 {
    public int[] func(int[] A){
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = 1;
            for (int j = 0; j < A.length; j++) {
                int temp = 0;
                if(j == i){
                    temp = 1;
                }
                else{
                    temp = A[j];
                }
                B[i] *= temp;
            }
        }
        return B;
    }
}
