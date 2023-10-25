package leetCode;

import java.util.Arrays;
import java.util.HashMap;

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

        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbers.length; i++){

            Integer diff;
            diff = (target - numbers[i]);
            if(hash.containsKey(diff)){
                return new int[]{hash.get(diff), i};
            }

            hash.put(numbers[i], i);

        }

        return null;
    }
}
