package leetCode;

/*
    https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

 */

public class FindFirstAndLastPositionBinarySearch_34 {
    public static void main(String[] args) {
        int[] array = {1, 3, 3, 5, 5, 5, 8, 9};
                    // 0  1  2  3  4  5  6  7
        int targetToFind = 5;
        int[] result = searchRange(array, targetToFind);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

    // Main logic to split binary search into more sub part
    public static int[] searchRange(int[] nums, int target) {

        if (nums.length < 1) {
            return new int[]{-1, -1};
        }

        int firstPos = binarySearch(nums, 0, nums.length - 1, target);

        if (firstPos == -1) {
            return new int[]{-1, -1};
        }

        int startPos = firstPos;
        int endPos = firstPos;
        int temp1=0, temp2 = 0;

        while (startPos != -1) {
            temp1 = startPos;
            startPos = binarySearch(nums, 0, startPos - 1, target);
        }
        startPos = temp1;

        while (endPos != -1) {
            temp2 = endPos;
            endPos = binarySearch(nums, endPos + 1, nums.length - 1, target);
        }
        endPos = temp2;

        return new int[]{startPos, endPos};
    }

    // Pure binary search logic
    public static int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int foundVal = nums[mid];
            if (foundVal == target) {
                return mid;
            } else if (foundVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
