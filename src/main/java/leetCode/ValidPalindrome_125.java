package leetCode;

/*
    https://leetcode.com/problems/valid-palindrome/
 */

public class ValidPalindrome_125 {

    /*
    Example 1:

        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Explanation: "amanaplanacanalpanama" is a palindrome.
        Example 2:

        Input: s = "race a car"
        Output: false
        Explanation: "raceacar" is not a palindrome.
        Example 3:

        Input: s = " "
        Output: true
        Explanation: s is an empty string "" after removing non-alphanumeric characters.
        Since an empty string reads the same forward and backward, it is a palindrome.
     */


    public static void main(String[] args) {
        //String s = "A man, a plan, a canal: Panama";
        String s = s = "race a car";
        System.out.println(isPalindrome(s));
    }

   static public boolean isPalindrome(String s){
        StringBuilder tempString = new StringBuilder();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c) || Character.isLetter(c)){
                tempString.append(c);
            }
        }

        tempString = new StringBuilder(tempString.toString().toLowerCase());
        int first = 0;
        int last = tempString.length()-1;

        while (first<=last){
            char startingChar = tempString.charAt(first);
            char endingChar = tempString.charAt(last);
            if(startingChar!=endingChar){
                return false;
            }

            first++;
            last--;
        }
        return true;
    }

}
