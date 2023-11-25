package leetCode.sliding_window;

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

/*
    this is sliding window problem related
 */

 // related problem with same logic
/*
  https://leetcode.com/problems/maximum-subarray/description/

 */

/*
  https://www.youtube.com/watch?v=56TxHMG0qhQ&list=PLFdAYMIVJQHPEjjf1sFo4svsIACsvXUw1

 */

/*
    https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

    Explanation:
    https://www.youtube.com/watch?v=t4sDawyBqYc
 */

//Sliding Window Algorithm

import java.util.Arrays;

public class PermutationInString_567 {

    public static void main(String[] args) {
        String input = "eidboaoo";
        String pattern = "abc";

        boolean result = containsPermutation(input, pattern);

        System.out.println("Does the string contain a permutation of the pattern? " + result);
    }

    public static boolean containsPermutation(String s, String pattern) {
        if (s == null || pattern == null || s.length() < pattern.length()) {
            return false;
        }

        int[] patternCount = new int[26];
        int[] windowCount = new int[26];

        // Initialize the counts for the pattern and the initial window
        for (int i = 0; i < pattern.length(); i++) {
            patternCount[pattern.charAt(i) - 'a']++;
            windowCount[s.charAt(i) - 'a']++;
        }

        // Slide the window through the string
        for (int i = pattern.length(); i < s.length(); i++) {
            // Check if the current window contains a permutation of the pattern
            if (Arrays.equals(patternCount, windowCount)) {
                return true;
            }

            // Update the window count: add the next character and remove the character leaving the window
            windowCount[s.charAt(i) - 'a']++;
            windowCount[s.charAt(i - pattern.length()) - 'a']--;
        }

        // Check for the last window
        return Arrays.equals(patternCount, windowCount);
    }
}

