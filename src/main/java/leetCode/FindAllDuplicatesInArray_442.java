package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

https://leetcode.com/problems/find-all-duplicates-in-an-array/

https://www.youtube.com/watch?v=5wdQI88O3Mc

 */



/*

Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.



Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []


Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
Each element in nums appears once or twice.
 */

public class FindAllDuplicatesInArray_442 {

    public static void main(String[] args) {
        //Input: nums = [4,3,2,7,8,2,3,1]
        //Output: [2,3]

        int[] nums = {2,3,3};
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
       List<Integer> result = new ArrayList<>();
       for(int i=0; i<nums.length; i++){
           int index = Math.abs(nums[i])-1;
           if(nums[index]<0){
               result.add(index+1);
           }
           nums[index] = nums[index]* -1;
       }
       return result;
    }
}

/* ======== explanation ===========
[4,3,2,7,8,2,3,1]
 0 1 2 3 4 5 6 7
nums[i] = 4; // i=0
index = 4-1 = 3;
num[3]=7
(7<0) = false
7 = -7;

[4,3,2,-7,8,2,3,1]
 0 1 2  3 4 5 6 7
nums[i] = 3; // i=1
index = 3-1 = 2;
num[2]=2
(2<0) = false
2 = -2;

[4,3,-2,-7,8,2,3,1]
 0 1  2  3 4 5 6 7
nums[i] = -2; // i=2
index = 2-1 = 1;
num[1]=3
(3<0) = false
3 = -3;

[4,-3,-2,-7,8,2,3,1]
 0  1  2  3 4 5 6 7
nums[i] = -7; // i=3
index = 7-1 = 6;
num[6]=3
(3<0) = false
3 = -3;

[4,-3,-2,-7,8,2,-3,1]
 0  1  2  3 4 5  6 7
nums[i] = 8; // i=4
index = 8-1 = 7;
num[7]=1
(1<0) = false
1 = -1;


[4,-3,-2,-7,8,2,-3,1]
 0  1  2  3 4 5  6 7
nums[i] = 2; // i=5
index = 2-1 = 1;
num[1]=-3
(-3<0) = true
result = [ index+1 ] = [1+1 = 2]
-3=-3


[4,-3,-2,-7,8,2,-3,1]
 0  1  2  3 4 5  6 7
nums[i] = -3; // i=6
index = 3-1 = 2;
num[2]=-2
(-2<0) = true
result = [ index+1 ] = [2+1 = 3]
-3=-3

[4,-3,-2,-7,8,2,-3,1]
 0  1  2  3 4 5  6 7
nums[i] = 1; // i=7
index = 1-1 = 0;
num[0]=4
(4<0) = false

4=-4


[-4,-3,-2,-7,8,2,-3,1]
*/
