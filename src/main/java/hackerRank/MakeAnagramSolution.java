package hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class MakeAnagramResult {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */



    public static int makeAnagram(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        //First count char and put into map
        for(int i=0;i<a.length();i++){
            if(map.get(a.charAt(i)) == null){
                map.put(a.charAt(i), 1);
            } else {
                int cur = map.get(a.charAt(i));
                map.put(a.charAt(i), cur+1);
            }
        }
        for(int i=0;i<b.length();i++){
            if(map.containsKey(b.charAt(i))){
                int cur = map.get(b.charAt(i));
                if(cur == 1){
                    map.remove(b.charAt(i));
                } else {
                    map.put(b.charAt(i), cur-1); // char exist in b string then reduce it value by one
                }
            } else {
                count++;
            }
        }

        for(Integer i: map.values()){
            count=count+i;
        }

        return count;
    }

}

public class MakeAnagramSolution {
    public static void main(String[] args) throws IOException {

        String a = "cdeee";

        String b = "dceff";

        //int res = MakeAnagramResult.makeAnagram(a, b);

        int nums[] = {2,7,11,15};
        int target = 9;

    }
}
