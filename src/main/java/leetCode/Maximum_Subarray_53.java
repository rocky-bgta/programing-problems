package leetCode;

public class Maximum_Subarray_53 {

    /*
        https://leetcode.com/problems/maximum-subarray/description/
     */

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubArray(nums);
    }

    //https://www.youtube.com/watch?v=GrNSGC8Z2T0

    public static int maxSubArray(int[] nums) {

        int max_so_far = nums[0];
        int curr_max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curr_max = Math.max(nums[i], nums[i] + curr_max);
            max_so_far = Math.max(curr_max, max_so_far);
        }

        return max_so_far;
    }
}
