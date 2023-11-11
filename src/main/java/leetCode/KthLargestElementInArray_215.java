package leetCode;

/*
    https://leetcode.com/problems/kth-largest-element-in-an-array/description/

    Explanation:
    https://www.youtube.com/watch?v=tmH8nOmO_m4
 */

import java.util.PriorityQueue;

public class KthLargestElementInArray_215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() < k) {
                minHeap.add(nums[i]);
            } else {
                if (minHeap.peek() < nums[i]) {
                    minHeap.remove();
                    minHeap.add(nums[i]);
                }
            }
        }

        return minHeap.peek();
    }
}
