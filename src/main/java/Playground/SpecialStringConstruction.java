package Playground;

import java.util.Arrays;

public class SpecialStringConstruction {

    public static int[] countMinimumCharacters(String s, String[] arr) {
        int n = s.length();
        int m = arr.length;
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            String target = arr[i];
            int[] targetCount = new int[10];

            // Count the occurrences of each digit in the target string
            for (char digit : target.toCharArray()) {
                targetCount[digit - '0']++;
            }

            int left = 0, right = 0;
            int[] currentCount = new int[10];
            int minLength = Integer.MAX_VALUE;

            // Slide the window to find the minimum substring
            while (right < n) {
                currentCount[s.charAt(right) - '0']++;

                // Check if the current substring contains a permutation of the target string
                while (containsPermutation(currentCount, targetCount)) {
                    // Update the minimum length and move the left pointer
                    minLength = Math.min(minLength, right - left + 1);
                    currentCount[s.charAt(left) - '0']--;
                    left++;
                }

                right++;
            }

            // If minLength is still Integer.MAX_VALUE, the target string cannot be constructed
            result[i] = (minLength == Integer.MAX_VALUE) ? -1 : minLength;
        }

        return result;
    }

    private static boolean containsPermutation(int[] currentCount, int[] targetCount) {
        for (int i = 0; i < 10; i++) {
            if (currentCount[i] < targetCount[i]) {
                return false;
            }
        }

        // Reset the currentCount array for the next iteration
        Arrays.fill(currentCount, 0);

        return true;
    }

    public static void main(String[] args) {
        String s = "064819848398";
        String[] arr = {"088", "364", "07"};

        int[] result = countMinimumCharacters(s, arr);
        System.out.println(Arrays.toString(result)); // Output: [7, 10, -1]
    }
}
