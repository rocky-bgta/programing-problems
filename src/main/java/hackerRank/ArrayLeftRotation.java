package hackerRank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ArrayLeftRotationResult {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        Integer[] ar = a.stream().toArray(Integer[]::new);
        int holder,i=0;
        for(int j=0; j<d; j++) {
            holder = ar[i];
            while (i < ar.length - 1) {
                ar[i] = ar[i + 1];
                i++;
            }
            ar[ar.length - 1] = holder;
            i=0;
        }
        List<Integer> integerList= Arrays.asList(ar);
        return integerList;
    }

}

public class ArrayLeftRotation {
    public static void main(String[] args) throws IOException {

        List<Integer> a = new ArrayList<>();
        a = Arrays.asList(1, 2, 3, 4, 5);
        int d = 4;
        List<Integer> result = ArrayLeftRotationResult.rotLeft(a, d);


    }
}
