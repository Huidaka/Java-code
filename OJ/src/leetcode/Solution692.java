package leetcode;
/**
 * 前k个高频单词
 */
import java.util.*;
public class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<String> priorityQueue = new PriorityQueue<>((s1, s2) -> {
            return map.get(s1) == map.get(s2) ? s2.compareTo(s1) :
                    map.get(s1) - map.get(s2);
        });

        for (String str : map.keySet()) {
            priorityQueue.offer(str);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        List<String> list = new ArrayList();
        while (!priorityQueue.isEmpty()) {
            list.add(priorityQueue.poll());
        }
        Collections.reverse(list);
        return list;
    }
}
