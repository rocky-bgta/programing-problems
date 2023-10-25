package leetCode;

/*
    https://leetcode.com/problems/rotate-array/description/

    https://www.youtube.com/watch?v=gmu0RA5_zxs&t=224s
 */

import java.util.Arrays;

public class Rotate_Array {
//            *) Let us consider this with an example : [1,2,3,4], k=2; output = [3,4,1,2]
//            *)  The intution is simple,  just the rotate the array.
//            *) Rotation one from 0 to n(where n is length of array)
//                  After rotation one : [4,3,2,1]
//            *) Rotation two from 0 to k-1,
//                  After rotation two : [3,4,2,1]
//            *) Rotation three from k to n,
//                  After rotation three : [3,4,1,2]
//            *) And here comes the output array, [3,4,1,2]
    public static void main(String[] args) {
        /*
        here array length 2 and also k value is 2
        so by doing % operation no rotation needed.
         */
        //System.out.println(2%2);

        int[] nums = {-1,-100,3,99};
        int k = 2;
        //System.out.println(nums.length);
        //k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

        System.out.println(Arrays.toString(nums));


        /*
        Example 1:

        Input: nums = [1,2,3,4,5,6,7], k = 3
        Output: [5,6,7,1,2,3,4]
        Explanation:
        rotate 1 steps to the right: [7,1,2,3,4,5,6]
        rotate 2 steps to the right: [6,7,1,2,3,4,5]
        rotate 3 steps to the right: [5,6,7,1,2,3,4]
        Example 2:

        Input: nums = [-1,-100,3,99], k = 2
        Output: [3,99,-1,-100]
        Explanation:
        rotate 1 steps to the right: [99,-1,-100,3]
        rotate 2 steps to the right: [3,99,-1,-100]

         */


    }



    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}


