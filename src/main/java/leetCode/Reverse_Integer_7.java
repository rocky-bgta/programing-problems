package leetCode;

import java.util.Map;

public class Reverse_Integer_7 {
    public static void main(String[] args) {
        //    reverse(123);

       double maxValue =  Math.pow(2, 31)-1;
       double minValue = -(Math.pow(2,31));
    }

    public static int reverse(int x) {
        long reversed = 0;
        int pop;

        while (x !=0){
            pop = x % 10;
            x = x/10;
            reversed  = (reversed * 10) + pop;
            if (reversed > Integer.MAX_VALUE || reversed<Integer.MIN_VALUE ) {
                return 0;
            }
        }

        return (int) reversed;
    }
}
