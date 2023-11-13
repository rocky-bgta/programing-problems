package leetCode;

/*
    https://leetcode.com/problems/k-diff-pairs-in-an-array/

    Explanation:
    https://www.youtube.com/watch?v=5L9Jrehvoew
 */

import java.util.HashMap;

public class K_Diff_Pairs_532 {
    public static void main(String[] args) {
        //all value of this consider as a of pair(a,b)
        int[] nums = {1, 1, 1, 1};
        int k = 2;

//        int k = 6;
//        int nums[] = {1, 5, 7, 1};
        System.out.println(findPairs(nums,k));
    }

    public static int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int interval = k - nums[i];
            int toSum;

            // If there exists an element in the map that forms a pair with the current element
            if (m.containsKey(k - nums[i])) {
                // Get the count of such elements
                toSum = m.get(interval);
                // Increment the total count by the number of pairs found
                count += toSum;
            }

            // Update the frequency of the current element in the map
            if (m.containsKey(nums[i])) {
                m.put(nums[i], m.get(nums[i]) + 1);
            } else {
                m.put(nums[i], 1);
            }
        }

        return count;
    }

//    public static int findPairs(int[] nums, int k) {
//        if (k < 0) {
//            return 0;
//        }
//
//        Map<Integer, Integer> frequencyMap = new HashMap<>();
//        int count = 0;
//
//        for (int num : nums) {
//            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
//        }
//
//        for (int key : frequencyMap.keySet()) {
//            if (k == 0) {
//                // Count the number of elements with more than one occurrence for k = 0
//                if (frequencyMap.get(key) > 1) {
//                    count++;
//                }
//            } else {
//                // Check if key + k is present in the map for other values of k
//                if (frequencyMap.containsKey(key + k)) {
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }

}
