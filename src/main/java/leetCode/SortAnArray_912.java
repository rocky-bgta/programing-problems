package leetCode;

import java.util.HashMap;
import java.util.Map;
/*
 https://leetcode.com/problems/sort-an-array/

 Explanation:
 https://www.youtube.com/watch?v=FiawvsBgYVs
*/
public class SortAnArray_912 {

    // Method to sort an array of integers
    public int[] sortArray(int[] nums) {

        // Create a HashMap to store the frequency of each number in the array
        Map<Integer, Integer> map = new HashMap<>();

        // Initialize min and max with the first element of the array
        int min = nums[0], max = nums[0];

        // Iterate through the array to populate the map and find the min and max values
        for (int i = 0; i < nums.length; i++) {
            // If the number is already in the map, increment its count
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                // Otherwise, add the number to the map with a count of 1
                map.put(nums[i], 1);
            }

            // Update the min value if the current number is smaller
            if (nums[i] < min) {
                min = nums[i];
            }

            // Update the max value if the current number is larger
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // Index to keep track of where to place the next number in the sorted array
        int index = 0;

        // Iterate from the min value to the max value
        for (int i = min; i <= max; i++) {
            // While there are still occurrences of the current number in the map
            while (map.getOrDefault(i, 0) > 0) {
                // Place the current number in the array
                nums[index] = i;
                // Move to the next position in the array
                index++;
                // Decrement the count of the current number in the map
                map.put(i, map.get(i) - 1);
            }
        }

        // Return the sorted array
        return nums;
    }
}
