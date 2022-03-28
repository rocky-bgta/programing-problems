package hackerRank;

import java.io.*;

import static java.util.stream.Collectors.joining;

class RepeatedStringResult {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
    // Write your code here
        long count=0;
        if(s.length()==1 && s.charAt(0)=='a'){
            return n;
        }

        while (s.length()<=n){
            s+=s;
        }
        s = s.substring(0, (int) n);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='a'){
                count++;
            }
        }

        return count;
    }

}

public class RepeatedString {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = bufferedReader.readLine();
//
//        long n = Long.parseLong(bufferedReader.readLine().trim());
        String s="aba";
        long n = 10;

        long result = RepeatedStringResult.repeatedString(s, n);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
