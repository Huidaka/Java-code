package nowcoder;

/**
 *青蛙跳台阶，一次可以跳一阶，二阶，三阶.(递归)
 */
public class Solution39 {
    public int countWays(int n) {
    if(n == 1){
        return 1;
    }
    if(n == 2){
        return 2;
    }
    if(n == 3){
        return 4;
    }
    return countWays(n-1)+countWays(n-2)+countWays(n-3);
}

    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        System.out.println(solution39.countWays(4));
    }
}
