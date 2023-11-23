package leetCode.sliding_window;


import java.util.HashMap;
import java.util.Map;

/*
    https://leetcode.com/problems/minimum-window-substring/description/

 */
public class MinimumWindowSubstring_76 {
    public static void main(String[] args) {
        //String s = "BANC", t = "BANC";
        String s = "ADOBECODEBANC", t = "ABC";
        String result = minWindow(s, t);
        System.out.println(result);
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
}
