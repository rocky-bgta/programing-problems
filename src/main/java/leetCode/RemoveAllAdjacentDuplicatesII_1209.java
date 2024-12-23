package leetCode;

import java.util.Stack;
/*
    https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

 */

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

//https://www.youtube.com/watch?v=RJpy4A7LJrs

//https://www.youtube.com/watch?v=afzSFD7wOvg

public class RemoveAllAdjacentDuplicatesII_1209 {

    // Node class to represent a character and its consecutive count in the stack
    static class Node {
        char ch;     // The character
        int times;   // The count of consecutive occurrences of the character

        // Constructor to initialize the node with a character and a default count of 1
        Node(char c) {
            ch = c;
            times = 1;
        }
    }

    public static void main(String[] args) {
        String s = "pbbcggttciiippooaais"; // Input string
        int k = 2; // The number of consecutive duplicates to remove
        System.out.println(removeDuplicates(s, k)); // Output: "ps"
    }

    // Method to remove all adjacent duplicates where a character appears k times consecutively
    public static String removeDuplicates(String s, int k) {
        int n = s.length(); // Get the length of the string
        if (n < k) return s; // If the string is shorter than k, no removal is possible

        // Stack to store characters and their consecutive counts
        Stack<Node> stack = new Stack<>();

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || c != stack.peek().ch) {
                // If the stack is empty or the current character is different from the top of the stack
                stack.push(new Node(c)); // Push a new Node with the current character
            } else {
                // If the current character matches the character at the top of the stack
                int times = stack.peek().times;
                if(times + 1 == k){
                    stack.pop();
                }else {
                    stack.peek().times++;
                }
            }
        }

        // StringBuilder to rebuild the final string from the stack
        StringBuilder sb = new StringBuilder();
        for (Node node : stack) {
            // Append each character in the stack as many times as its count
            sb.append(String.valueOf(node.ch).repeat(node.times));
        }

      /*

        StringBuilder sb = new StringBuilder();
        for(Node node: stack){
            int times = node.times;
            for(int i=0; i<times; i++){
                sb.append(node.ch);
            }
        }

        */

        // Return the final modified string
        return sb.toString();
    }
}