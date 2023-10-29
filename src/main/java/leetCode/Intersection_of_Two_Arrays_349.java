package leetCode;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/intersection-of-two-arrays/
public class Intersection_of_Two_Arrays_349 {

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

        Set<Integer> interjectionSet = new HashSet<>();
        int i=0; int j=0;
        while (i<n && j<m){
            if(nums1[i]>nums2[j]) {
                j++; //move small value pointer;
            }else if(nums1[i]<nums2[j]){
                i++; //move small value pointer;
            }else {
                interjectionSet.add(nums1[i]); // when both are equal it can also be result.add(nums2[j])
                i++;  // increment both pointer
                j++;  //
            }

        }
        int[] result = new int[interjectionSet.size()];
        i = 0;
        for (int x : interjectionSet)
            result[i++] = x;

        return result;
    }

    // https://www.youtube.com/watch?v=dP8CAXKISX0
    public int[] intersection(int[] nums1, int[]nums2){
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums1){
            set.add(i);
        }

        HashSet<Integer> intersection = new HashSet<>();
        for(int i: nums2){
            if(set.contains(i)){
                intersection.add(i);
            }
        }

        int[] result = new int[intersection.size()];
        int index=0;
        for(int i: intersection){
            result[index++]=i;
        }

        return result;
    }
}
