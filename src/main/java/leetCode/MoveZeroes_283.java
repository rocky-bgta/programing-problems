package leetCode;

/*

https://leetcode.com/problems/move-zeroes/description/

https://www.youtube.com/watch?v=k5lIW5XxC7g

"Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Input: nums = [0]
Output: [0]"
 */

public class MoveZeroes_283 {


    public static void main(String[] args) {
        //int nums[] =  {0,0,1,0,0,1};

       // int nums[] =  {0,1,0,3,12};

        int nums[] =  {1,0};
        //[1,0]

    }

    public void moveZeroes(int[] nums) {

        // Start with the first position
        int insertPosition = 0;

        for (int i = 0; i < nums.length; i++) {
            // FIll all non-zero numbers
            if (nums[i] != 0) {
                nums[insertPosition] = nums[i];
                insertPosition++;
            }
        }

        while (insertPosition < nums.length) {
            nums[insertPosition++] = 0;
        }
    }
}
