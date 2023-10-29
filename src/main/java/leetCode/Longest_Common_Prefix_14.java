package leetCode;

/*
    https://leetcode.com/problems/longest-common-prefix/description/

    https://www.youtube.com/watch?v=wtOQaovlvhY
 */

import java.util.Arrays;

public class Longest_Common_Prefix_14 {

    public static void main(String[] args) {
        String strs[] = {"flower","flow","flight"};
        longestCommonPrefix(strs);
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        // Sort the array
        Arrays.sort(strs);

        // Get the first and last strings
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        // Start comparing
        for (int i = 0; i < first.length; i++) {
            if (first[i] != last[i])
                break;
            result.append(first[i]);
        }

        return result.toString();
    }

}
