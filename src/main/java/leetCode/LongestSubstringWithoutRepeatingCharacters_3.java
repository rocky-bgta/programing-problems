package leetCode;

import java.util.HashSet;
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

}
