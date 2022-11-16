package leetCode;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
//https://www.youtube.com/watch?v=aMsSF1Il3IY

public class FindAllDuplicatesInArray_442 {

    public static void main(String[] args) {
        //Input: nums = [4,3,2,7,8,2,3,1]
        //Output: [2,3]

        int[] nums = {4,3,2,7,8,2,3,1};
        findDuplicates(nums);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
}
