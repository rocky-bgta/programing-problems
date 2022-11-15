package leetCode;/*
"Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Input: nums = [0]
Output: [0]"
 */

public class MoveZeroes_283 {


    public static void main(String[] args) {
        int nums[] =  {0,0,1,0,0,1};


        if(nums.length==1)
            if(nums[0]==0)
                return;

        int left=0, right=0;
        int temp;

        while (right<nums.length){
            if(nums[right]==0) {
                ++right;
            }else {
                temp = nums[left];
                nums[left] = nums[right];
                nums[right]= temp;
                ++left;
                ++right;
            }
        }
    }
}
