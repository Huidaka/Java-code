package nowcoder;
/**
 *青蛙跳台阶，一次可以跳一阶，二阶，三阶.(非递归)
 */
public class Solution39_1 {
    public int countWays(int n) {
        if(n<3){
            return n;
        }
        if(n == 3){
            return 4;
        }
        int a = 1;
        int b = 2;
        int c = 4;
        int ret = 0;
        for (int i = 4; i <= n; i++) {
            ret = ((a+b)%1000000007+c)%1000000007;
            a = b;
            b = c;
            c = ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution39_1 solution39_1 = new Solution39_1();
        System.out.println(solution39_1.countWays(5));
    }
}
