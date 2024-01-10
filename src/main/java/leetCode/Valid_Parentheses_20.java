package leetCode;

import java.util.Stack;

/*
    https://leetcode.com/problems/valid-parentheses/description/
 */
public class Valid_Parentheses_20 {

    public static void main(String[] args) {
        String s = "([}}])";
        isValid(s);
    }

    //https://www.youtube.com/watch?v=9kmUaXrjizQ
    public static boolean isValid(String s) {

        // must be even number of char that is at least 2 char
        if (s.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else
                return false;

        }

        return stack.isEmpty();
    }
}
