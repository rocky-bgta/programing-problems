package leetCode;

import java.util.*;

public class Intersection_of_Two_Arrays_350 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        //intersect(nums1,nums2);
        intersect(nums1,nums2);
    }

    //https://www.youtube.com/watch?v=dTmYy5yCSX8
    public static int[] intersect(int[] nums1, int[]nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n = nums1.length;
        int m = nums2.length;

        List<Integer> interjectionList = new ArrayList<>();
        int i=0; int j=0;
        while (i<n && j<m){
            if(nums1[i]>nums2[j]) {
                j++; //move small value pointer;
            }else if(nums1[i]<nums2[j]){
                i++; //move small value pointer;
            }else {
                interjectionList.add(nums1[i]); // when both are equal it can also be result.add(nums2[j])
                i++;  // increment both pointer
                j++;  //
            }

        }
        int[] result = new int[interjectionList.size()];

        i = 0;
        for (int x : interjectionList)
            result[i++] = x;

        return result;
    }
}
