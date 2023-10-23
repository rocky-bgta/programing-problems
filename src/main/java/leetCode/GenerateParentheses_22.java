package leetCode;

import java.util.ArrayList;
import java.util.List;
/*

 https://leetcode.com/problems/generate-parentheses/

 */

public class GenerateParentheses_22 {

    public static void main(String[] args) {
        generateParenthesis(1);
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        dfs(result, new StringBuilder(), n, n);
        return result;
    }
    /*
    left and right represents the remaining number of ( and ) that need to be added.
    When left > right, there are more ")" placed than "(". Such cases are wrong and the method stops.
    */
    public static void dfs(ArrayList<String> result, StringBuilder s, int left, int right){
        if(left > right)
            return;

        if(left==0&&right==0){
            result.add(s.toString());
            return;
        }
        // finally s put into result
        if(left>0){
            System.out.println("left value = " + (left-1));
            dfs(result, s.append("("), left-1, right);
        }
        //actually s append the result
        if(right>0){
            System.out.println("right value = " + (right-1));
            dfs(result, s.append(")"), left, right-1);
        }
        //actually s append the result
    }
}
