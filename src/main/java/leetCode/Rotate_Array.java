package leetCode;

public class Rotate_Array {

    public static void main(String[] args) {
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


