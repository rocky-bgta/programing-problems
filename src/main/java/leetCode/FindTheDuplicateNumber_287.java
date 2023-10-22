package leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber_287 {

    public static void main(String[] args) {
       int[] nums = {1,3,4,2,2};
       FindTheDuplicateNumber_287 findTheDuplicateNumber287 = new FindTheDuplicateNumber_287();
       findTheDuplicateNumber287.findDuplicate(nums);

    }
    public int findDuplicate(int[] nums) {

        // Start a fast and slow pointer
        // until they meet
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            System.out.println("slow : "+slow);
            fast = nums[nums[fast]];
            System.out.println("fast : "+fast);
        } while (slow != fast);

        // As soon as they meet, move both
        // pointers at same speed until they
        // meet again
        System.out.println("================================");
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            System.out.println("slow : "+slow);
            fast = nums[fast];
            System.out.println("fast : "+fast);
        }
        return slow;
    }

    public int findDuplicatesSorting(int[] nums) {
        Arrays.sort(nums);

        int prev = -1;
        for (int num : nums) {
            if (num == prev)
                break;
            prev = num;
        }

        return prev;
    }

    public int findDuplicatesHashSet(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            if (numSet.contains(num))
                return num;
            numSet.add(num);
        }

        return -1;
    }
}
