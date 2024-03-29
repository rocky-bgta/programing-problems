package leetCode;


/*

  https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

 */

import java.util.Stack;

// https://www.youtube.com/watch?v=hXEEr5WekSQ
public class RemoveAllAdjacentDuplicate_1047 {

    /*
    Example 1:

    Input: s = "abbaca"
    Output: "ca"
    Explanation:
    For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
    Example 2:

    Input: s = "azxxzy"
    Output: "ay"
     */


    public static void main(String[] args) {

        String s="abb  aca";
        removeDuplicates(s);
//        char[] stack = new char[s.length()];
//        int i = 0;
//
//        for(int j=0; j<s.length(); j++){
//            char current_char = s.charAt(j);
//
//            if(i>0 && stack[i-1]==current_char){
//                i--;
//            }else {
//                stack[i] = current_char;
//                i +=1;
//            }
//        }
//
//        String result = new String(stack, 0,i);
//
//        System.out.printf("result "+ result);

    }
//https://www.youtube.com/watch?v=Y9etfBQpYIo
    public static String removeDuplicates(String s){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            if(!stack.isEmpty() && s.charAt(i)==stack.peek()){
                stack.pop();
                sb.setLength(sb.length()-1);
            }else {
                stack.push(s.charAt(i));
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
