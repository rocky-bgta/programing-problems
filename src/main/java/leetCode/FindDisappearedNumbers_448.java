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

    public static List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1; // here -1 add because array index is 0 base

            // now mark the value with negative
            if(nums[index]>0){
                nums[index] = nums[index]* -1;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }

}
