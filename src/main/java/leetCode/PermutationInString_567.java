package leetCode;

import java.util.HashMap;
import java.util.Map;

/*
    https://leetcode.com/problems/permutation-in-string/description/

 Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false


Input
s1 =
"hello"
s2 =
"ooolleoooleh"

Output
true
Expected
false


 */

public class PermutationInString_567 {

    public static void main(String[] args) {
        //String s1 = "ab", s2 = "eidboaoo";
       // String s1 = "hello", s2="ooolleoooleh";

//        Input: s1 = "ab", s2 = "eidbaooo"
//        Output: true

         String s1 = "adc", s2= "dcda";
         //Output: true

        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        Map<Character, Integer> windowFrequency = new HashMap<>();
        int windowLength = s1.length();
        boolean result=false;
        for (int i = 0; i < windowLength; i++) {
            if (!charFrequency.containsKey(s1.charAt(i))) {
                charFrequency.put(s1.charAt(i), 1);
            } else {
                charFrequency.put(s1.charAt(i), charFrequency.getOrDefault(i,0) + 1);
            }
        }

        // sliding window with give length logic
        int left = 0;
        int count = 0;

        int windowSize = s1.length();
        int right = windowSize-1;

        //s2 = "eidbaooo";
        for(int i=0; i<s2.length(); i++){
            while(count<=right && left<s2.length()-1){
                System.out.println(s2.charAt(i)+"-->");

                if (charFrequency.containsKey(s2.charAt(i))) {

                    if (!windowFrequency.containsKey(s2.charAt(i))) {
                        windowFrequency.put(s2.charAt(i), 1);
                    } else {
                        windowFrequency.put(s2.charAt(i), windowFrequency.getOrDefault(s2.charAt(i),0) + 1);
                    }

                }

                if (charFrequency.size() == windowFrequency.size()) {
                    for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {

                        if (windowFrequency.get(entry.getKey()) != entry.getValue()) {
                            result = false;
                        }else {
                            result = true;
                        }
                    }

                }

                if(result){
                    return result;
                }

                left++;
                count++;
            }
            left--;
            count=0;
            windowFrequency.clear();
        }

        return result;
    }
}

