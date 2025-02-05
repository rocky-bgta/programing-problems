package leetCode;

/*

    https://leetcode.com/problems/valid-palindrome-ii/description/

 */


/*
    Check udemy course solution
 */

public class ValidPalindrome_II_680 {
    public static void main(String[] args) {
        ValidPalindrome_II_680 solution = new ValidPalindrome_II_680();
        System.out.println(solution.validPalindrome("abca")); // Output: true
        System.out.println(solution.validPalindrome("abc"));  // Output: false
    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Try deleting either the left or the right character
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
