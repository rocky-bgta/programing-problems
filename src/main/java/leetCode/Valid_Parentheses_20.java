package leetCode;

import java.util.Stack;

public class Valid_Parentheses_20 {

    public static void main(String[] args) {
        String s = "([}}])";
        isValid(s);
    }


    public static boolean isValid(String s) {


        if(s.length()%2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();

        for( char c : s.toCharArray()){
            if(c =='(' || c == '{' || c=='[' ){
                stack.push(c);
            }else if(c == ')' && !stack.isEmpty() && stack.peek()=='('){
                stack.pop();
            }else if(c == '}' && !stack.isEmpty() && stack.peek()=='{'){
                stack.pop();
            }else if(c==']' && !stack.isEmpty() && stack.peek()=='['){
                stack.pop();
            }else
                return false;

        }

        return stack.isEmpty();


    }
}
