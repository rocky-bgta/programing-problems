package hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class PairCountResult {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        //String[] arTemp = {"1", "1", "3", "1","2", "1", "3", "3", "3", "3"};
        Integer[] arrayList = ar.stream().toArray(Integer[]::new);
        int pairCount = 0;


        for(int i=0; i<arrayList.length; i++){
            for(int j=i+1; j<arrayList.length; j++){
                if(arrayList[i]==arrayList[j] && arrayList[i]!=-1){
                    pairCount++;
                    System.out.println("Pair Number "+ arrayList[i]);
                    arrayList[i]=-1;
                    arrayList[j]=-1;
                    break;
                }
            }
        }

        return pairCount;
    }

}

public class PairCount {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
       String[] arTemp = {"1", "1", "3", "1","2", "1", "3", "3", "3", "3"};


        List<Integer> ar = new ArrayList<>();



        for (int i = 0; i < arTemp.length; i++) {
            int arItem = Integer.parseInt(arTemp[i]);
            ar.add(arItem);
        }

        int result = PairCountResult.sockMerchant(7, ar);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
