package leetCode;
/*
    https://leetcode.com/problems/palindrome-number/
 */

public class Palindrome_Number_9 {


    /*
        Input: x = 121
        Output: true
        Explanation: 121 reads as 121 from left to right and from right to left.

        Input: x = -121
        Output: false
        Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
        Therefore it is not a palindrome.

        Input: x = 10
        Output: false
        Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     */

    public static void main(String[] args) {
        Integer result, inputNumber;
        inputNumber =  new Integer(125);
        result = inputNumber%10;
        System.out.println(result);

        isPalindrome(121);
    }

    public static boolean isPalindrome(int x) {

        int originalNumber =x;
        if(x==0)
            return true;
        if(x<0){
            return false;
        }

        int reversedInteger = 0;


        while(x>0){
            int pop = x%10;
            x=x/10;
            reversedInteger = (reversedInteger*10) + pop;
        }

        if(originalNumber == reversedInteger){
            return true;
        }else {
            return false;
        }


    }

}



