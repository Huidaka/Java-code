package leetcode;

import java.util.*;

/**
 * 找到k个最接近x的数
 * 用comparator实现绝对值排序
 */
public class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return Math.abs(integer - x) - Math.abs(t1 - x);
            }
        });
        list = list.subList(0,k);
        Collections.sort(list);
        return list;
    }
}
