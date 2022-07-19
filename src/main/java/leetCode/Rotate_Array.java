package leetCode;

public class Rotate_Array {
//            *) Let us consider this with an example : [1,2,3,4], k=2; output = [3,4,1,2]
//            *)  The intution is simple,  just the rotate the array.
//            *) Rotation one from 0 to n(where n is length of array)
//                  After rotation one : [4,3,2,1]
//            *) Rotation two from 0 to k-1,
//                  After rotation two : [3,4,2,1]
//            *) Rotation three from k to n,
//                  After rotation three : [3,4,1,2]
//            *) And here comes the output array, [3,4,1,2]
    public static void main(String[] args) {
        /*
        here array length 2 and also k value is 2
        so by doing % operation no rotation needed.
         */
        System.out.println(2%2);

        int[] nums = {1,2,3,4,5,6,7,8};
        int k = 10;
        System.out.println(nums.length);
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }


    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}


