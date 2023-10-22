package agoda.preparation;

import java.util.Arrays;

public class MergeSortedArray_88 {
    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int m = 3;
        int[] nums2 = {1,2,3};
        int n = 3;

        //merge(nums1, m, nums2, n);

        twoPointerApproach(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n - 1;
        int j = 0;
        for (int i = m; i <= length; i++) {
            nums1[i] = nums2[j];
            j++;
        }

        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));

    }

    public static void twoPointerApproach(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = 0;
        int holder;

        int length = m+n-1;

        if(length!=0) {
            for (int i = m - 1; i < length; i++) {
                if (nums1[p1] > nums2[p2]) {
                    holder = nums1[p1];
                    nums1[p1] = nums2[p2];
                    p1++;
                    nums1[p1] = holder;
                    p2++;
                } else if (nums1[p1] < nums2[p2]) {
                    p1++;
                    nums1[p1] = nums2[p2];
                    p2++;
                } else if (nums1[p1] == nums2[p2]) {
                    p1++;
                    p2++;
                }
            }
        }else if(m==0 && n==1){
            nums1[0]=nums2[0];
        }

    }
}
