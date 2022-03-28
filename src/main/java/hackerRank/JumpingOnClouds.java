package hackerRank;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class JumpingOnCloudsResult {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        Integer path = 0;
        Integer[] cJ = c.stream().toArray(Integer[]::new);
        int i = 0;
        while (i < cJ.length-1) {
            if(i+2<=cJ.length-1) {
                if (cJ[i] == 0 && cJ[i + 2] == 0) {
                    path += 1;
                    i += 2;
                }
            }else if (cJ[i] == 0 && cJ[i + 1] == 0) {
                path = path + 1;
                i += 1;
            }
        }
        return path;
    }

}

public class JumpingOnClouds {
    public static void main(String[] args) throws IOException {
        //String[] arTemp = {"0", "1", "0", "0", "0", "1", "0"};
        //String[] arTemp = {"0", "0", "1", "0", "0", "1", "0"};
        //String[] arTemp = {"0", "0", "0", "0", "1", "0"};
        String[] arTemp = {"0", "0", "0", "1", "0", "0"};





        List<Integer> ar = new ArrayList<>();


        for (int i = 0; i < arTemp.length; i++) {
            int arItem = Integer.parseInt(arTemp[i]);
            ar.add(arItem);
        }

        int result = JumpingOnCloudsResult.jumpingOnClouds(ar);
    }
}
