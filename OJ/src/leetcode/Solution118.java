package leetcode;

import java.util.ArrayList;
import java.util.List;
/*
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if(numRows <= 0){
            throw new RuntimeException();
        }
        ret.add(new ArrayList<>());
        ret.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            List<Integer> prevRow = ret.get(i-1);
            curRow.add(1);
            for (int j = 1; j < i; j++) {
                int temp = prevRow.get(j)+prevRow.get(j-1);
                curRow.add(temp);
            }
            curRow.add(1);
        }
        return ret;
    }
}
