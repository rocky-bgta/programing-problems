package leetCode.util;

import java.util.Scanner;

/*
    https://www.youtube.com/watch?v=bWrsk0QizEk&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=6
    Explanation
 */

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int i = 0;
        int ans = 0;

        while (n != 0){
            int digit = n % 2;
            if(digit == 1){
                ans = ans + (int) Math.pow(10, i);
            }

            n = n / 2;
            i++;
        }
        System.out.println(ans);

    }
}
