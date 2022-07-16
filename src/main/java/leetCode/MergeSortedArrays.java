package leetCode;

public class MergeSortedArrays {

    public int[] merge(int[] nums1, int m, int[] nums2, int n){

        int i = m-1;
        int j = n-1;
        int k = (m+n -1);

        while (i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else {
                nums1[k--] = nums2[j--];
            }
        }

        while (i>=0){
            nums1[k--] = nums1[i--];
        }
        while (j>=0){
            nums1[k--] = nums2[j--];
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
