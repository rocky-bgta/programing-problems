package leetCode;

import java.util.Arrays;

public class ValidAnagram {

    public static void main(String[] args) {
       String s = "anagram";
       String t = "nagaram";

       ValidAnagram.isAnagram(s,t);
    }

    public static boolean isAnagram(String s, String t){

        char[] str1;
        char[] str2;

        str1 = s.toCharArray();
        str2 = t.toCharArray();
        // Get lengths of both strings
        int n1 = str1.length;
        int n2 = str2.length;

        // If length of both strings is not same,
        // then they cannot be anagram
        if (n1 != n2)
            return false;

        // Sort both strings
        Arrays.sort(str1);
        Arrays.sort(str2);

        // Compare sorted strings
        for (int i = 0; i < n1; i++)
            if (str1[i] != str2[i])
                return false;

        return true;
    }
}
