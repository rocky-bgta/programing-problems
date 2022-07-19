package leetCode;

public class MergeSortedArrays {
//
//    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//    Output: [1,2,2,3,5,6]
//    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

    public int[] merge(int[] nums1, int m, int[] nums2, int n){

        int i = m-1;
        int j = n-1;
        int k = (m+n -1);

        System.out.println("Value of K: " + k);

        while (i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (i>=0){
            nums1[k] = nums1[i];
            i--;
            k--;
        }
        while (j>=0){
            nums1[k--] = nums2[j];
            j--;
            k--;
        }

        return nums1;
    }

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSortedArrays msa = new MergeSortedArrays();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        msa.printArray(nums1);
        msa.printArray(nums2);

        int[] result = msa.merge(nums1, 3, nums2, 3);
        msa.printArray(result);
    }

}
