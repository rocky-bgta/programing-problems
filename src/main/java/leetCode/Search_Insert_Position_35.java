package leetCode;
/*
    https://leetcode.com/problems/search-insert-position/

 */

public class Search_Insert_Position_35 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;

        searchInsert(nums, target);
    }

    /*
        https://www.youtube.com/watch?v=p07ahfFzMi0
    */

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found at index mid
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        // If the target is not found, left will point to the insertion index
        return left;
    }

}
