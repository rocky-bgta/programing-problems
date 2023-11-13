package leetCode;

/*
    https://leetcode.com/problems/kth-largest-element-in-an-array/description/

    Explanation:
    https://www.youtube.com/watch?v=tmH8nOmO_m4

    Example 1:

    Input: nums = [3,2,1,5,6,4], k = 2
    Output: 5
    Example 2:

    Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
    Output: 4

 */

import java.util.PriorityQueue;

public class KthLargestElementInArray_215 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k=2;
        findKthLargest(nums,k);

    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() < k) { // this line restrict heap size
                minHeap.add(nums[i]);
            } else {
                if (minHeap.peek() < nums[i]) { //this logic implement min heap
                    minHeap.remove();
                    minHeap.add(nums[i]);
                }
            }
        }

        return minHeap.peek();
    }
}
