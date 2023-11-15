package Playground;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "064819848398";
        String[] arr = {"088", "364", "07"};
        int[] result = countMinimumCharacters(s, arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] countMinimumCharacters(String s, String[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            int[] freq = new int[10];
            for (char c : str.toCharArray()) {
                freq[c - '0']++;
            }
            int left = 0, right = 0, count = str.length(), min = Integer.MAX_VALUE;
            while (right < s.length()) {
                if (freq[s.charAt(right) - '0'] > 0) {
                    count--;
                }
                freq[s.charAt(right) - '0']--;
                right++;
                while (count == 0) {
                    min = Math.min(min, right - left);
                    if (freq[s.charAt(left) - '0'] == 0) {
                        count++;
                    }
                    freq[s.charAt(left) - '0']++;
                    left++;
                }
            }
            res[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return res;
    }
}
