package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*

    https://leetcode.com/problems/contains-duplicate/description/

 */

public class ContainsDuplicate_217 {

    /*
    Here trick is we put array value for both key and value of HashMap

    Example 1:

    Input: nums = [1,2,3,1]
    Output: true
    Example 2:

    Input: nums = [1,2,3,4]
    Output: false
    Example 3:

    Input: nums = [1,1,1,3,3,4,3,2,4,2]
    Output: true

     */

    public boolean containsDuplicate(int[] nums) {

        Map<Integer,Integer> holder = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(holder.containsKey(nums[i])){
                return true;
            }
            holder.put(nums[i], nums[i]);
        }
        return false;
    }

    public boolean containsDuplicateUsingSet(int[] nums) {

        // Create a HashSet to store unique elements
        Set<Integer> holder = new HashSet<>();

        // Iterate through the array
        /*
            The add() method returns false if the element is already present in the set,
            so we check if the value is already added.
            If it's already there, the method returns true because a duplicate is found.
         */
        for (int num : nums) {
            // If the number is already in the set, return true
            if (!holder.add(num)) {
                return true;
            }
        }

        // If no duplicates were found, return false
        return false;
    }

}
