package leetCode.Palindrome;

public class StringReverseMethod {
    public static void main(String[] args) {
        String string = "A man, a plan, a canal: Panama";
        boolean isValidPalindrome = isValidPalindrome(string);
        System.out.println("Is valid palindrome: " + isValidPalindrome);
    }

    public static boolean isValidPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        StringBuilder rev = new StringBuilder();

        // Generate a reverse string using a reverse for loop.
        for (int i = s.length() - 1; i >= 0; i--) {
            rev.append(s.charAt(i));
        }

        return rev.toString().equals(s);
    }
}
