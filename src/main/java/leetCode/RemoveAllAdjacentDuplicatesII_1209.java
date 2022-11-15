package leetCode;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesII_1209 {
    public static void main(String[] args) {
        //Input: s = "deeedbbcccbdaa", k = 3
        String s = "deeedbbcccbdaa";
        int k=3;

        removeDuplicates(s,k);
    }

    //https://www.youtube.com/watch?v=RJpy4A7LJrs
    public static String removeDuplicates(String s, int k){
        Stack<Character> main = new Stack<>();

        for(char c: s.toCharArray()){
            Stack<Character> temp = new Stack<>();
            temp.push(c);

            while (!main.isEmpty() && main.peek()==c){
                temp.push(main.pop());
            }

            if(temp.size()!=k){
                while (!temp.isEmpty()){
                    main.push(temp.pop());
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!main.isEmpty()){
            sb.append(main.pop());
        }

        return sb.reverse().toString();
    }

}
