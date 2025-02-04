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
        // Test array
        int[] arr = {1, 2, 2, 1, 1, 3};

        // Call the method and print the result
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {

        // Create a HashMap to store the frequency of each element in the array
        Map<Integer, Integer> map = new HashMap<>();

        // Create a HashSet to store unique frequencies
        Set<Integer> set = new HashSet<>();

        // Iterate through the array and populate the HashMap with frequencies
        for (int i = 0; i < arr.length; i++) {
            // If the element is already in the map, increment its count by 1
            // Otherwise, add it to the map with a count of 1
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Iterate through the values (frequencies) in the HashMap
        for (int value : map.values()) {
            // Try to add each frequency to the HashSet
            // If the frequency is already in the HashSet, it means it's not unique
            if (!set.add(value)) {
                return false; // Return false if a duplicate frequency is found
            }
        }

        // If all frequencies are unique, return true
        return true;
    }
}
