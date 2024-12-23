package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/*
    https://leetcode.com/problems/unique-number-of-occurrences/

 */
public class UniqueNumberOfOccurrences_1207 {

    public static void main(String[] args) {
       int[] arr = {1,2,2,1,1,3};
       uniqueOccurrences(arr);
    }

    public static boolean uniqueOccurrences(int[] arr) {

        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();


        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }

        for(int value: map.values()){
            if(!set.add(value)){
                return false;
            }
        }
        return true;
    }
}
