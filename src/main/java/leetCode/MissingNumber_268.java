package leetCode;

/*
    https://leetcode.com/problems/missing-number/description/
 */
public class MissingNumber_268 {

    /*
        https://www.youtube.com/watch?v=iCrQG_kbuP0
     */

    int missingNumber(int[] nums) {

        int allXOR = 0;

        // XOR all numbers in range [0, n]
        for (int i = 0; i <= nums.length; i++) {
            allXOR = allXOR ^ i;
        }

        // XOR all numbers in the given array
        for (int num : nums) {
            allXOR = allXOR ^ num;
        }

        // The missing number
        return allXOR;
    }
}
