package leetCode;

import java.util.Stack;
/*
    https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

 */

public class RemoveAllAdjacentDuplicatesII_1209 {

   static class Node{
        char ch;
        int times;
        public Node(char c){
            ch =c;
            times=1;
        }
    }

    /*
    Example 1:

    Input: s = "abcd", k = 2
    Output: "abcd"
    Explanation: There's nothing to delete.
    Example 2:

    Input: s = "deeedbbcccbdaa", k = 3
    Output: "aa"
    Explanation:
    First delete "eee" and "ccc", get "ddbbbdaa"
    Then delete "bbb", get "dddaa"
    Finally delete "ddd", get "aa"
    Example 3:

    Input: s = "pbbcggttciiippooaais", k = 2
    Output: "ps"
     */
    public static void main(String[] args) {
        //Input: s = "eeedbbcccbdaa", k = 3
        String s = "pbbcggttciiippooaais";
        int k=2;

        System.out.println(removeDuplicates(s,k));
    }

    //https://www.youtube.com/watch?v=RJpy4A7LJrs

    //https://www.youtube.com/watch?v=afzSFD7wOvg
    public static String removeDuplicates(String s, int k){

        int n = s.length();
        if(n<k) return s;

        Stack<Node> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty() || c!=stack.peek().ch){
                stack.push(new Node(c));
            }else {
                int times = stack.peek().times;
                if(times + 1 == k){
                    stack.pop();
                }else {
                    stack.peek().times++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
            for(Node node: stack){
                int times = node.times;
                for(int i=0; i<times; i++){
                    sb.append(node.ch);
                }
        }

        return sb.toString();
    }

}
