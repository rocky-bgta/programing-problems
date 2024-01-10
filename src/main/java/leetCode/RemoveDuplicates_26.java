package leetCode;

public class RemoveDuplicates_26 {


    /*


    https://leetcode.com/problems/remove-duplicates-from-sorted-array/

    Example 1:

    Input: nums = [1,1,2]
    Output: 2, nums = [1,2,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).
    Example 2:

    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).
     */

    public static void main(String[] args) {
        int nums[] = {1,1,2};
        removeDuplicates(nums);

        //int maxValue = (int) Math.pow(2, 31) - 1;
        //System.out.println("Max value: "+ maxValue);
    }
/*
    Input: nums = [1,1,2]
    Output: 2, nums = [1,2,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).
    Example 2:
 */

    public static int removeDuplicates(int[] nums) {

        int i = 0;

        for(int j=1; j<nums.length; j++){ // if equal no need to increment i value
            if(nums[i] != nums[j]){ // [ 1 , 1 ]
                nums[++i] = nums[j]; // if not then then increment value
            }
        }

        return ++i;

    }

}
