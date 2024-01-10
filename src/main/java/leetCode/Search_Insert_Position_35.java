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
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = (high + low) / 2;

            if (nums[mid] == target) {
                return mid;             // target = 5
            } else if (nums[mid] > target) { // 1  2  3  4  5  6  7  8  9  10
                high = mid - 1;         // here if nums[mid] point to 7
            } else {
                low = mid + 1;            //discard left side (because mid is smaller then target value)
            }
        }

        return low;
    }

}
