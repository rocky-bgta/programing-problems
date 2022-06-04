package hackerRank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class RansomNoteResult {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
    // Write your code here
        Map<String,Integer> mazHash = new HashMap<>();
        Map<String,Integer> noteHash = new HashMap<>();

    }

}

public class RansomNoteResultSolution {
    public static void main(String[] args) throws IOException {


        List<String> magazine; //= Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            //.collect(toList());

        List<String> note; // = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            //.collect(toList());

        String ma[] = "two times three is not four".split(" ");
        String not[] = "two times two is four".split(" ");
        magazine = Arrays.stream(ma).collect(toList());
        note = Arrays.stream(not).collect(toList());

        RansomNoteResult.checkMagazine(magazine, note);
    }
}
