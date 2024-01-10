package leetCode;
/*
  https://leetcode.com/problems/consecutive-characters/

  https://www.youtube.com/watch?v=O5ugFbLN-zY

 */

/*

The power of the string is the maximum length of a non-empty substring that contains only one unique character.

Given a string s, return the power of s.



Example 1:

Input: s = "leetcooode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.


=======================
Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters.

 */

public class ConsecutiveCharacters_1446 {

           static int maxPower(String s){
                int ans =1;
                int count =1;

                for(int i=1; i<s.length(); i++){
                    if(s.charAt(i)==s.charAt(i-1)){ // e e e f
                        count++;                    // 0 1 2 3
                    }else {
                        ans = Math.max(ans,count);
                        count=1;
                    }
                }
                ans = Math.max(ans,count);
                return ans;
            }


    public static void main(String[] args) {
        //String s = "leetcode";
        String s = "leetcooode";
        System.out.println(maxPower(s));
    }

}
