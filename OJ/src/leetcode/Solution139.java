package leetcode;

import java.util.List;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0 || wordDict.size() == 0){
            return false;
        }
        for(String str : wordDict){
            if(s.contains(str)){
                if(s.contains(s.replaceFirst(str,"")))
                    s = s.replaceAll(str,"");
            }
        }
        return s.equals("");
    }
}
