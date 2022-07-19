package leetCode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

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
