package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum_1 {
//
//    Input: nums = [2,7,11,15], target = 9
//    Output: [0,1]
//    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] result= twoSum(nums,target);
        System.out.printf(Arrays.toString(result));

    }

    public static int[] twoSum(int[] numbers, int target) {

        // Create a hash map to store numbers and their indices
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();

        // Iterate through the array
        for (int i = 0; i < numbers.length; i++) {

            // Calculate the difference between the target and the current number
            Integer diff = (target - numbers[i]);

            // Check if the difference exists in the hash map
            if (hash.containsKey(diff)) {
                // If it exists, return the indices of the two numbers
                return new int[]{hash.get(diff), i};
            }

            // Otherwise, add the current number and its index to the hash map
            hash.put(numbers[i], i);
        }

        // If no pair is found, return null
        return null;
    }
}
