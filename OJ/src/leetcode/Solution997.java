package leetcode;

/**
 * 小镇法官问题
 */
public class Solution997 {
    public int findJudge(int N, int[][] trust) {
        int[] indegree = new int[N+1];
        int[] outdegree = new int[N+1];
        for (int[] temp : trust) {
            indegree[temp[1]]++;
            outdegree[temp[0]]++;
        }
        for (int i = 1; i < N+1; i++) {
            if(indegree[i] == N-1 && outdegree[i] == 0){
                return i;
            }
        }
        return -1;
    }
}
