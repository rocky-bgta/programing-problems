package leetCode;

import java.util.HashMap;
import java.util.Map;

public class Remove_Duplicates {

    public static void main(String[] args) {
        int nums[] = {1,1,2};
        removeDuplicates(nums);

        Map<Integer,Integer> holder = new HashMap<>();
        char[] s;

        int maxValue = (int) Math.pow(2, 31) - 1;
        System.out.println("Max value: "+ maxValue);
    }


    public static int removeDuplicates(int[] nums) {

        int i = 0;

        for(int j=1; j<nums.length; j++){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }

        return ++i;

    }

}
