package leetCode;

/*
    https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

    Explanation:
    https://www.youtube.com/watch?v=oEBHLcucDYg

 */

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers_448 {

    public static void main(String[] args) {
        int[] inputs = {4,3,2,7,8,2,3,1};
        List<Integer> result = findDisappearedNumbers(inputs);
        System.out.println(result);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        // Step 1: Mark presence of numbers in the array
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Map the value to an index (1-based to 0-based)
            nums[index] = -Math.abs(nums[index]); // Mark the number at this index as negative
        }

        // Step 2: Collect indices of positive numbers
        List<Integer> missingNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) { // Positive numbers indicate missing values
                missingNumbers.add(i + 1); // Convert 0-based index to 1-based
            }
        }

        return missingNumbers;
    }

}
