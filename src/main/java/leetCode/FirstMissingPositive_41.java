package leetCode;

/*
    https://leetcode.com/problems/first-missing-positive/description/

    Explanation video:
    https://www.youtube.com/watch?v=DhdS_jHF_q4&t=322s
 */

public class FirstMissingPositive_41 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 0};
        System.out.println(firstMissingPositive(nums1)); // Output: 3

        int[] nums2 = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums2)); // Output: 2

        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(nums3)); // Output: 1
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number at its correct index

        /*
            If a number is k, its correct position in a 0-based array is k - 1.
            Example: In an array of size 5 ([1, 2, 3, 4, 5]),
            the number 1 belongs at index 0, the number 2 belongs at index 1, and so on.

            The number is positive (nums[i] > 0).
            The number is within the range [1, n] (nums[i] <= n).
            The number is not already in its correct position (nums[nums[i] - 1] != nums[i]).
        */
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // Step 2: Find the first index where nums[i] != i + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all indices are correct, return n + 1
        return n + 1;
    }

    // Helper function to swap elements in the array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
