package leetCode;

import java.util.HashMap;
import java.util.Map;

/*
    https://leetcode.com/problems/permutation-in-string/description/

 Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false


Input
s1 =
"hello"
s2 =
"ooolleoooleh"

Output
true
Expected
false


 */

public class PermutationInString_567 {

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        Map<Character, Integer> windowFrequency = new HashMap<>();
        int windowLength = s1.length();

        for (int i = 0; i < windowLength; i++) {
            if (!charFrequency.containsKey(s1.charAt(i))) {
                charFrequency.put(s1.charAt(i), 1);
            } else {
                charFrequency.put(s1.charAt(i), charFrequency.get(i) + 1);
            }
        }

        // sliding window with give length logic
        int index = 0;
        while (index < s2.length()) {
            for (int j = 0; j < windowLength; j++) {
                System.out.println(s2.charAt(index));
                if (charFrequency.containsKey(s2.charAt(index))) {

                    if (!windowFrequency.containsKey(s2.charAt(index))) {
                        windowFrequency.put(s2.charAt(index), 1);
                    } else {
                        windowFrequency.put(s2.charAt(index), windowFrequency.get(s2.charAt(index)) + 1);
                    }

                }
                index++;
            }
        }

        if (charFrequency.size() != windowFrequency.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            if (windowFrequency.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }

        return true;

    }
}

