package leetcode;

/**
 * 超级次方
 */
public class Solution372 {
    public int superPow(int a, int[] b) {
        int numB=0;
        a=a%1337;
        if(a==0){
            return 0;
        }
        for(int i=0;i<b.length;i++){
            numB+=b[i];
            numB*=10;
        }
        numB/=10;
        int x=a;
        for(int j=0;j<numB;j++){
            x=x%1337;
            x*=a;
        }x/=a;
        return x;
    }

}
