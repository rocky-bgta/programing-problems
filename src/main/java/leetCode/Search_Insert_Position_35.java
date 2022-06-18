package leetCode;

public class Search_Insert_Position_35 {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;

        searchInsert(nums,target);
    }


    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high){

            int mid = low + (high-low)/2;

            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }

        return low;
    }

}
