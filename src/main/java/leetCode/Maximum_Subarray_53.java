package leetCode;

public class Maximum_Subarray_53 {


    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }
    //https://www.youtube.com/watch?v=HCL4_bOd3-4
    public static int maxSubArray(int[] nums) {

        int sum = nums[0];
        int output = nums[0];
        for(int i=1; i<nums.length;i++){

            System.out.println(sum+nums[i]);
            System.out.println("nums["+i+"] " +" sum+nums["+i+"]" + (sum+nums[i])  );
            sum = Math.max(nums[i],sum+nums[i]);
            output = Math.max(output,sum);
        }

        return output;

    }
}
