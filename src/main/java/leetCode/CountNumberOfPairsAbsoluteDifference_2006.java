package leetCode;

import java.util.HashMap;
import java.util.Map;

/*

https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/


Explanation:
https://www.youtube.com/watch?v=geXHhqUWGw8

 */

public class CountNumberOfPairsAbsoluteDifference_2006 {

    public int countKDifferenceBrutForce(int[] nums, int k) {
        int count = 0;

        for(int i=0; i<nums.length; i++){

            for(int j=i+1; j<nums.length; j++ ){
                if(Math.abs(nums[i]-nums[j])==k){
                    count++;
                }
            }

        }
        return count;

    }

    public int countKDifference(int[] nums, int k) {
        int count = 0;
        Map<Integer,Integer> m = new HashMap<>();

        for(int i=0; i<nums.length; i++){

            if(m.containsKey(nums[i]-k)){
                count += m.get(nums[i]-k);
            }

            if(m.containsKey(nums[i]+k)){
                count+=m.get(nums[i]+k);
            }

            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        return count;

    }
}
