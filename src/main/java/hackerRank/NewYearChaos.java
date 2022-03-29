package hackerRank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class NewYearChaosResult {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
    // Write your code here
        int swapCount = 0;
        Integer arr[] = q.stream().toArray(Integer[]::new);

        for(int i = arr.length -1; i>=0; i--){
            if(arr[i] != i+1){ // filter cases, when you do not bribe, be at ith position wherever you are
                if( ((i-1)>=0) && arr[i-1] == (i+1)){
                    swapCount++;
                    swap(arr,i, i-1);
                }else if(((i-2)>=0) && arr[i-2] == (i+1)){
                    swapCount+=2;
                    swap(arr, i-2, i-1);
                    swap(arr, i-1,i);
                }else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(swapCount);

    }
    private static void swap(Integer[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}

public class NewYearChaos {
    public static void main(String[] args) throws IOException {
        List<Integer> a = new ArrayList<>();
        a = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8);
        NewYearChaosResult.minimumBribes(a);
    }
}
