package leetCode;

/*

    https://leetcode.com/problems/valid-palindrome-ii/description/

 */


/*
    Check udemy course solution
 */

public class ValidPalindrome_II_680 {
    public static void main(String[] args) {
        String string = "abca";
        boolean isValid = validPalindrome(string);
        System.out.println("Is valid palindrome: " + isValid);
    }

    public static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return validSubPalindrome(s, start + 1, end) || validSubPalindrome(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean validSubPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
