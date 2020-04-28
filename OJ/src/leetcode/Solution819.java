package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet();
        for (String word : banned) {
            set.add(word);
        }
        Map<String, Integer> map = new HashMap<>(set.size());

        String regex = "[ !?',;.]";
        String[] words = paragraph.toLowerCase().split(regex);

        String ans = "";
        int ansFreq = 0;
        for (String word : words) {
            if (word.length() > 0 && !set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
                if (map.get(word) > ansFreq) {
                    ansFreq = map.get(word);
                    ans = word;
                }
            }
        }
        return ans;
    }
}
