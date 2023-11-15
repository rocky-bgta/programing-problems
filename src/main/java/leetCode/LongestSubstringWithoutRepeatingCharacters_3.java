package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

    //Brute Force solution
    public int lengthOfLongestSubstring(String str) {
        int maxCount = 0;
        for (int i = 0; i < str.length(); i++) {
            Set<Character> visited = new HashSet<>();
            int count = 0;
            for (int j = i; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (!visited.contains(ch)) {
                    visited.add(ch);
                    count++;
                    maxCount = Math.max(count, maxCount);
                } else {
                    break;
                }
            }

        }
        return maxCount;
    }

    // Explanation Udemy Section 6: String Question
    // sliding window method:
    public int longestSubstring(String s){
        Map<Character,Integer> seenChar = new HashMap<>();

        int longestSubString =0;

        if(s.length()<=1){
            return s.length();
        }

        int left = 0;
        for(int right =0; right<s.length(); right++){

            // a        a       c       d       e           e               e       e
           //  0        1       2       3       4           5               6       7
           //                                   prevChar    currentChar
           //                                   this prevChar already inside our hashmap
            char currentChar = s.charAt(right);
            Integer prevSeenCharIndex = seenChar.get(currentChar);
            if(prevSeenCharIndex !=null && prevSeenCharIndex >= left){
                left = prevSeenCharIndex+1;
            }

            seenChar.put(currentChar,right);// put char index in hashmap
            longestSubString = Math.max(longestSubString, (right - left+1));
                                    // here we add one because of 0 index base

        }
        return longestSubString;
    }

}
