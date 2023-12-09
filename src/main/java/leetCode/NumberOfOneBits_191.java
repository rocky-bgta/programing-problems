package leetCode;

/*
    https://leetcode.com/problems/number-of-1-bits/

    Explanation:
    https://www.youtube.com/watch?v=yjdQHb2elqI&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=6
    Please go to 1:15 time slot
 */

public class NumberOfOneBits_191 {

    /**
     * Calculates the Hamming weight of a given number.
     * The Hamming weight is the number of bits set to 1 in the binary representation of the number.
     *
     * @param n the number for which to calculate the Hamming weight
     * @return the Hamming weight of the given number
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
