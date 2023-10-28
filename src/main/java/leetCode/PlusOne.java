package leetCode;

/*
    https://leetcode.com/problems/plus-one/description/

 */

public class PlusOne {
    /*
    Input: digits = [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.
    Incrementing by one gives 123 + 1 = 124.
    Thus, the result should be [1,2,4].
    Example 2:

    Input: digits = [4,3,2,1]
    Output: [4,3,2,2]
    Explanation: The array represents the integer 4321.
    Incrementing by one gives 4321 + 1 = 4322.
    Thus, the result should be [4,3,2,2].
    Example 3:

    Input: digits = [9]
    Output: [1,0]
    Explanation: The array represents the integer 9.
    Incrementing by one gives 9 + 1 = 10.
    Thus, the result should be [1,0].
    */

    public static void main(String[] args) {
        int[] digits = {99};
        plusOne(digits);
    }

    public static int[] plusOne(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }

            digits[i]=0;
        }
//        Input: digits = [9]
//        Output: [1,0]
        int [] new_number = new int[n+1];
        new_number[0]=1;
        return new_number;

    }
}
