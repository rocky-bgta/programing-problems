package leetCode.Palindrome;

public class TwoPointerFromMiddle {
    public static void main(String[] args) {
        String string = "A man, a plan, a canal: Panama";
        boolean isValidPalindrome = isValidPalindrome(string);
        System.out.println("Is valid palindrome: " + isValidPalindrome);
    }

    public static boolean isValidPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int left = s.length() / 2;
        int right = left;

        if (s.length() % 2 == 0) {
            left--;
        }

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left--;
            right++;
        }

        return true;
    }
}
