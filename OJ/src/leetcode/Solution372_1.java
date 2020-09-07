package leetcode;

import java.util.LinkedList;

public class Solution372_1 {
    int mod = 1337;
    int superPow(int n,int[] nums){
        LinkedList<Integer> list = new LinkedList<>();
        for (int e:nums)
            list.add(e);

        return myPow(n,list);
    }

    private int myPow(int n, LinkedList<Integer> list) {
        if(list.size() == 0){
            return 1;
        }
        n = n%mod;
        int last = list.removeLast();
        int num1 = quickPow(n,last);
        int num2 = quickPow(myPow(n,list),10);
        return (num1*num2)%1337;
    }

    private int quickPow(int a, int b){
        a = a%mod;
        int ret = 1;
        while (b>0){
            if((b & 1) == 1){
                ret = (ret * a )% mod;
            }
            b = b/2;
            a = (a*a)%mod;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution372_1 solution372_1 = new Solution372_1();
        int[] b = new int[]{1,0};
        System.out.println(solution372_1.superPow(2, b));
    }
}
