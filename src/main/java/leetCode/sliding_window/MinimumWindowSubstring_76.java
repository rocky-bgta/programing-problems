package leetCode.sliding_window;


import java.util.HashMap;
import java.util.Map;

/*
    https://leetcode.com/problems/minimum-window-substring/description/

 */
public class MinimumWindowSubstring_76 {
    public static void main(String[] args) {
        //String s = "abc", t = "bc";
        //String s = "BANC", t = "BANC";
        //String s="a", t="aa";
        // String s= "ab", t="a"; // a
        //String s = "bbaa", t = "aba"; // baa
        String s = "ADOBECODEBANC", t = "ABC";
        String result = minWindow2(s, t);
        System.out.println(result);
    }

    /*
        a b c
        ab bc
        abc
     */

    public static String minWindow2(String s, String t) {
        String result = "";

        if (s == null || t == null)
            return result;

        if (s.length() == t.length()) {
            if (t.equals(s)) {
                return t;
            }
        }


        String windowString = "";
        boolean isBreak = false;

        int left=0;
        int right = s.length();
        int windowSize = right-left;
        int count = 0;
        char ch;
        int index;

        Integer minWindowLength = Integer.MAX_VALUE;
        Map<Character, Integer> freMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            freMap.put(c, freMap.getOrDefault(c, 0) + 1);
        }

        // Creating temMap to keep original intact
        Map<Character, Integer> temFreMap = new HashMap<>();
        temFreMap.putAll(freMap);

        while (left < s.length()) {
            index = left;
            while (count < windowSize-1 && index < s.length()) {
                ch = s.charAt(index);
                windowString += ch;
                System.out.print(ch);
                count++;
                index++;

                if (temFreMap.containsKey(ch)) {
                    temFreMap.put(ch, temFreMap.get(ch) - 1);
                }
            }



            //============================================================================
            for (Map.Entry<Character, Integer> entry : temFreMap.entrySet()) {
                if (entry.getValue() != 0) {
                    isBreak = true;
                    break;
                } else {
                    isBreak = false;
                }
            }

            if (!isBreak) {
                //result = windowString;
                if (windowString.length() < minWindowLength) {
                    minWindowLength = windowString.length();
                    result = windowString;
                }

            } else {
                isBreak = false;
            }

            temFreMap.putAll(freMap); // return back initial frequency
            windowString = "";
            //======================================================================

            count = 0;
            left++;
            windowSize = right - left+1;
            System.out.println();
        }


        return result;

    }

    public static String minWindow1(String s, String t) {
        String result = "";
        String windowString = "";
        boolean isBreak = false;
        int count = 0;
        int windowSize = 1; //
        int windowCount = 0;
        int index = 0;
        char ch;

        if (s == null || t == null)
            return result;

        if (s.length() == t.length()) {
            if (t.equals(s)) {
                return t;
            }
        }

        if (s.length() == 1 && t.length() == 1) {
            if (t.equals(s)) {
                return t;
            }
        }

        if (s.length() == 1 && t.length() == 2) {
            return result;
        }
        if (s.length() == 2 && t.length() == 2) {
            if (t.equals(s)) {
                return t;
            }
        }


        if (s.length() % 2 != 0) {
            s += " ";
        }
        if (s.length() == 2) {
            s += " ";
        }

        Integer minWindowLength = Integer.MAX_VALUE;
        Map<Character, Integer> freMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            freMap.put(c, freMap.getOrDefault(c, 0) + 1);
        }

        // Creating temMap to keep original intact
        Map<Character, Integer> temFreMap = new HashMap<>();
        temFreMap.putAll(freMap);

        for (windowSize = 1; windowSize < s.length(); windowSize++) {
            while (windowCount < windowSize || windowCount <= s.length() - 1) {
                while (count < windowSize && index < s.length()) {
                    ch = s.charAt(index);
                    System.out.print(ch);
                    windowString += ch;
                    count++;
                    index++;

//                    if (temFreMap.containsKey(ch)) {
//                        temFreMap.put(ch, freMap.get(ch) - 1);
//                    }
                }


                //============================================================================


//                for (Map.Entry<Character, Integer> entry : temFreMap.entrySet()) {
//                    if (entry.getValue() != 0) {
//                        isBreak = true;
//                        break;
//                    } else {
//                        isBreak = false;
//                    }
//                }
//
//                if (!isBreak) {
//                    //result = windowString;
//                    if (windowString.length() < minWindowLength) {
//                        minWindowLength = windowString.length();
//                        result = windowString;
//                    }
//
//                } else {
//                    isBreak = false;
//                }
//
//                temFreMap.putAll(freMap); // return back initial frequency
//                windowString = "";
                //======================================================================


//                if (windowSize == s.length() - 1) {
//                    break;
//                }

                count = 0;
                if (windowSize > 1) {
                    index--;
                }
                windowCount++;
                System.out.print(" ");
            }


            index = 0;
            windowCount = 0;
            System.out.println();
        }

        return result;
    }


    public static String minWindow(String s, String t) {
        //List<Character> result = new ArrayList<>();
        //corner-case
        if (t != null && s != null && t.length() > s.length()) {
            return "";
        }

        if (t == null || s == null) {
            return "";
        }
        // List<Character> finalResult = new ArrayList<>();
        String result = "";

        //Map<String,Integer> resultFreq = new HashMap<>();
        Integer minWindowLength = Integer.MAX_VALUE;

        Map<Character, Integer> freMap = new HashMap<>();
        for (char f : t.toCharArray()) {
            if (freMap.containsKey(f)) {
                freMap.put(f, freMap.get(f) + 1);
            } else {
                freMap.put(f, freMap.getOrDefault(f, 1));
            }
        }

        // Creating temMap to keep original intact
        Map<Character, Integer> temFreMap = new HashMap<>();
        temFreMap.putAll(freMap);


        //window
        int left = 0, right = 1;
        int windowSize = right - left + 1;
        int count = 0;
        int index = 0;
        boolean isBreak = false;
        String windowString = "";
        while (right < s.length()) {

            while (count < windowSize && index < s.length()) {
                char ch = s.charAt(index);

                System.out.print(ch);
                windowString += ch;

                if (temFreMap.containsKey(ch)) {
                    temFreMap.put(ch, freMap.get(ch) - 1);
                }
                count++;
                index++;
                if (count == windowSize || index == s.length()) { // after completing one window iteration check if s found
                    count = 0;

                    //finalResult.add(ch);
                    //finalResult.clear();

                    for (Map.Entry<Character, Integer> entry : temFreMap.entrySet()) {
                        if (entry.getValue() != 0) {
                            isBreak = true;
                            break;
                        } else {
                            isBreak = false;
                        }
                    }

                    if (!isBreak) {
                        //result = windowString;
                        if (windowString.length() < minWindowLength) {
                            minWindowLength = windowString.length();
                            result = windowString;
                        }

                    } else {
                        isBreak = false;
                    }


                    temFreMap.putAll(freMap); // return back initial frequency
                    //finalResult.clear();
                    System.out.print(" ");
                    windowString = "";
                }

            }
            System.out.println();
            System.out.println("==========");


            count = 0;
            index = 0;
            right++; // right boundary always increment by one so window also increase
            windowSize = right - left + 1; // increase the window size

        }


        return result;
    }

    public static String minWindowSubstring(String s, String t) {
        // Check for invalid input
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Map to store the frequency of each character in the target string
        Map<Character, Integer> targetFreqMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreqMap.put(c, targetFreqMap.getOrDefault(c, 0) + 1);
        }

        // Variables to track the number of required characters and the window boundaries
        int requiredChars = targetFreqMap.size();
        int left = 0, right = 0;
        int formedChars = 0;

        // Map to store the frequency of characters in the current window
        Map<Character, Integer> windowFreqMap = new HashMap<>();

        // Variables to track the minimum window substring
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;

        // Iterate through the string using the sliding window technique
        while (right < s.length()) {
            char currentChar = s.charAt(right);

            // Update the window frequency map for the current character
            windowFreqMap.put(currentChar, windowFreqMap.getOrDefault(currentChar, 0) + 1);

            // Check if the current character satisfies the required count in the target
            if (targetFreqMap.containsKey(currentChar) &&
                    targetFreqMap.get(currentChar).equals(windowFreqMap.get(currentChar))) {
                formedChars++;
            }

            // Try to minimize the window by moving the left pointer
            while (formedChars == requiredChars && left <= right) {
                int currentLength = right - left + 1;

                // Update the minimum window substring
                if (currentLength < minLength) {
                    minLength = currentLength;
                    minLeft = left;
                    minRight = right + 1;
                }

                char leftChar = s.charAt(left);

                // Update the window frequency map for the left character
                windowFreqMap.put(leftChar, windowFreqMap.get(leftChar) - 1);

                // Check if the left character contributes to the required count
                if (targetFreqMap.containsKey(leftChar) &&
                        targetFreqMap.get(leftChar) > windowFreqMap.get(leftChar)) {
                    formedChars--;
                }

                // Move the left pointer to shrink the window
                left++;
            }

            // Move the right pointer to expand the window
            right++;
        }

        // Return the minimum window substring or an empty string if not found
        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(minLeft, minRight);
    }
}
