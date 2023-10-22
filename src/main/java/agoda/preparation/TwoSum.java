package agoda.preparation;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {

        int nums[] = {2,5,5,11};
        int target = 10;

      //  twoSum(nums,target);

        System.out.println(Arrays.toString(twoSum(nums,target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result =null;
        if(nums.length<2)
            return nums;

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j]==target){
                    result = new int[2];
                    result[0]=i;
                    result[1]=j;
                    break;
                }

            }
            if(result!=null){
                break;
            }
        }
        return result;
    }
}
