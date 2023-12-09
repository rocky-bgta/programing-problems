package leetCode.util;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int i = 0;
        int ans = 0;

        while (n != 0) {
            int digit = n % 10;

            if (digit == 1) {
                ans = ans + (int) Math.pow(2, i);
            }

            n = n / 10;
            i++;
        }

        System.out.println(ans);
    }
}
