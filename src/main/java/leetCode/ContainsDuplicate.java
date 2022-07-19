package leetCode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

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

}
