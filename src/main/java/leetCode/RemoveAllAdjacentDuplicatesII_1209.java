package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesII_1209 {

   static class Node{
        char ch;
        int times;
        public Node(char c){
            ch =c;
            times=1;
        }
    }

    public static void main(String[] args) {
        //Input: s = "eeedbbcccbdaa", k = 3
        String s = "deee";
        int k=3;

        removeDuplicates(s,k);
    }

    //https://www.youtube.com/watch?v=RJpy4A7LJrs

    //https://www.youtube.com/watch?v=afzSFD7wOvg
    public static String removeDuplicates(String s, int k){

        int n = s.length();
        if(n<k) return s;

        Deque<Node> stack = new ArrayDeque<>();
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

        return sb.reverse().toString();
    }

}
