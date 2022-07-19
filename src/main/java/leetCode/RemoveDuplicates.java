package leetCode;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        //Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
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
