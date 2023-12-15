package leetCode.util;

/*
The expression "nCr" represents a combination in mathematics, specifically a binomial coefficient. It is also read as "n choose r" or "n taken r at a time." The binomial coefficient is used to represent the number of ways to choose r elements from a set of n distinct elements without regard to the order of selection.

The formula for nCr is given by:
nCr = n!/r!(n-r)!

where:
n! (n factorial) is the product of all positive integers up to n.
r! (r factorial) is the product of all positive integers up to r.

In words,
nCr
represents the number of distinct combinations of choosing r elements from a set of n elements.
The order in which the elements are chosen does not matter.

For example, if you have a set of 5 elements {A, B, C, D, E},
the number of ways to choose 3 elements (3 combinations) from this set would be
5C3 = 10. The combinations might include {A, B, C}, {A, B, D}, {A, B, E}, and so on.
 */

public class nCr {

    public static void main(String[] args) {
        System.out.println(nCr(8,2));
    }

    static int factorial(int n) {
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }

        return fact;
    }

    static int nCr( int n, int r){
        int num = factorial(n);

        int denom = factorial(r) * (factorial(n-r));
        int ans = num/denom;
        return ans;
    }
}

