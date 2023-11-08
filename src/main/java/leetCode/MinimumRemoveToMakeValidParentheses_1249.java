package leetCode;

import java.util.Stack;

/*
    https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
 */

public class MinimumRemoveToMakeValidParentheses_1249 {

    public static void main(String[] args) {
        String s = "))((";
        minRemoveToMakeValid(s);
    }

    // Udemy explanations
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else if(s.charAt(i)==')' && !stack.isEmpty()){
                stack.pop();
            }else if(s.charAt(i)==')'){
                s = s.substring(0, i) + s.substring(i + 1);
                s= " "+s;
            }
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            s = s.substring(0, index) + s.substring(index + 1);
        }

        return s.trim();

    }
}
