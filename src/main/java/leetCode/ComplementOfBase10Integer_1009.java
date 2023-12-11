package leetCode;
/*
    https://leetcode.com/problems/complement-of-base-10-integer/description/


    Explanation:
    https://www.youtube.com/watch?v=0fwrMYPcGQ0&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=7
    Time slot: 27:24

 */
public class ComplementOfBase10Integer_1009 {
    public static void main(String[] args) {
        bitwiseComplement(5);
    }
    public static int bitwiseComplement(int n) {

        int m = n;
        int mask = 0;

        //edge case
        if(n==0){
            return 1;
        }

       while (m!=0){
           mask = (mask<<1)|1;
           m=m>>1;
       }

       int ans = (~n) & mask;
       return ans;
    }
}