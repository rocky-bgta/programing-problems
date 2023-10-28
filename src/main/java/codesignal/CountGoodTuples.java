package codesignal;


/*
    You're given an array of integers a.
    Let's call (a[i - 1], a[i], a[i + 1]) a good tuple,
    if exactly 2 out of the 3 numbers in it are equal.
    For example, (2, 1, 2) is a good tuple, but (1, 1, 1) and (1, 2, 3) are not.


    Example:
    Suppose the input array is a = [1, 1, 1, 2, 1, 3, 4].
                                    0  1  2  3  4  5  6
    At index i = 1: (a[i - 1], a[i], a[i + 1]) = (1, 1, 1). This does not form a good tuple.
    At index i = 2: (a[i - 1], a[i], a[i + 1]) = (1, 1, 2). This forms a good tuple.
    At index i = 3: (a[i - 1], a[i], a[i + 1]) = (1, 2, 3). This does not form a good tuple.
    At index i = 4: (a[i - 1], a[i], a[i + 1]) = (1, 1, 3). This forms a good tuple.
    At index i = 5: (a[i - 1], a[i], a[i + 1]) = (1, 3, 4). This does not form a good tuple.

just implement this below test data check that all.
     a[0]   a[1]    a[2]
       1      1       2
       1      2       1
       2      1       1

 Within the loop, the code checks three conditions for each triplet of numbers (a[i - 1], a[i], a[i + 1]):

(a[i - 1] == a[i] && a[i] != a[i + 1]):
This condition checks if the middle number a[i] is equal to the number on its left (a[i - 1])
but not equal to the number on its right (a[i + 1]).

(a[i - 1] != a[i] && a[i] == a[i + 1]):
This condition checks if the middle number a[i] is not equal to the number on its left
(a[i - 1]) but is equal to the number on its right (a[i + 1]).

(a[i - 1] == a[i + 1] && a[i] != a[i - 1]):
This condition checks if the number on the left (a[i - 1]) is equal to the number on the right
(a[i + 1]) but is not equal to the middle number a[i].

 */
public class CountGoodTuples {
    public static int countGoodTuples(int[] a) {
        int count = 0;
        for (int i = 1; i < a.length - 1; i++) { // check a.length-1 here
            if (
                    (a[i - 1] == a[i] && a[i] != a[i + 1]) ||
                    (a[i - 1] != a[i] && a[i] == a[i + 1]) ||
                    (a[i - 1] == a[i + 1] && a[i] != a[i - 1])) {
                count++;
            }
        }
        return count;
    }
}
