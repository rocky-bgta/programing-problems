package Playground;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

            String s = "064819848398";
            String[] arr = {"088", "364", "07"};
            int[] result = countMinimumCharacters(s, arr);
            System.out.println(Arrays.toString(result));

    }
    public static int[] countMinimumCharacters(String s, String[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int[] freq = new int[10];
            int count = 0;
            int left = 0;
            for (int right = 0; right < s.length(); right++) {
                char c = s.charAt(right);
                freq[c - '0']++;
                if (map.containsKey(c) && freq[c - '0'] <= map.get(c)) {
                    count++;
                }
                while (count == str.length()) {
                    if (result[i] == 0 || result[i] > right - left + 1) {
                        result[i] = right - left + 1;
                    }
                    char leftChar = s.charAt(left);
                    freq[leftChar - '0']--;
                    if (map.containsKey(leftChar) && freq[leftChar - '0'] < map.get(leftChar)) {
                        count--;
                    }
                    left++;
                }
            }
            if (result[i] == 0) {
                result[i] = -1;
            }
        }
        return result;
    }
}
