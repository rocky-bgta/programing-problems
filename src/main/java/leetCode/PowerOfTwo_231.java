package leetCode;

/*
    https://leetcode.com/problems/power-of-two/description/
 */

public class PowerOfTwo_231 {

    public static void main(String[] args) {
        isPowerOfTwo(5);
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        //int count=0;

        int ans = 1;

        for (int i = 0; i <= 30; i++) {
            // count++;
            //int ans = (int) Math.pow(2,i);

            if (ans == n) {
                return true;
            }
            //if(ans<Integer.MAX_VALUE/2)
                ans = ans * 2;
        }
        // System.out.println(count);
        return false;
    }
}
