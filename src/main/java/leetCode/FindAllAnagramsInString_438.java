package leetCode;


import java.util.ArrayList;
import java.util.List;

/*
    https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

    Explanation:
    https://www.youtube.com/watch?v=t4sDawyBqYc



 */

/*
    This is sliding window problem
    this problem also related to

    https://leetcode.com/problems/maximum-subarray/description/
    https://www.youtube.com/watch?v=56TxHMG0qhQ&list=PLFdAYMIVJQHPEjjf1sFo4svsIACsvXUw1
 */
public class FindAllAnagramsInString_438 {
    public List<Integer> findAnagrams(String s, String p) {
        int len_s = s.length();
        int len_p = p.length();

        if (len_s < len_p) return new ArrayList<>();

        int[] pFreq = new int[26];
        int[] window = new int[26];

        // First window
        for (int i = 0; i < len_p; i++) {
            pFreq[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }

        List<Integer> ans = new ArrayList<>();
        if (isEqual(pFreq, window)) ans.add(0);

        for (int i = len_p; i < len_s; i++) {
            window[s.charAt(i - len_p) - 'a']--;
            window[s.charAt(i) - 'a']++;

            if (isEqual(pFreq, window)) ans.add(i - len_p + 1);
        }

        return ans;
    }

    private boolean isEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindAllAnagramsInString_438 solution = new FindAllAnagramsInString_438();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println(result); // Output: [0, 6]
    }
}
