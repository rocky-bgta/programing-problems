package leetCode;


// https://leetcode.com/problems/find-the-town-judge/


//https://www.youtube.com/watch?v=2AdzmA1IC1k

import java.util.Arrays;

/*
Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: n = 3, trust = [[1,3],[2,3]]
Output: 3

 */
public class FindTheTownJudge_997 {


    public static int findJudge(int N, int[][] trust){
        int[] count = new int[N+1];
        for(int[] t: trust){
            count[t[0]]--;
            count[t[1]]++;
        }

        System.out.println(Arrays.toString(count));

        for(int i=1; i<=N; i++){
            if(count[i]==N-1)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int N = 3;
        int[][] trust = {{1,3},{2,3}};
        findJudge(N,trust);
    }

}

/*
 Input: n = 3, trust = [[1,3],[2,3]]
 Output: 3
  count = [N+1]
  count = [0,0,0,0]
           0 1 2 3

  for => [1,3]          count[0,-1,0,1]
          0 1                 0  1 2 3

  for => [2,3]          count[0,-1,-1,2]
          0 1







 */

