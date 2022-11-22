package coderbyte;

import java.util.*;
import java.io.*;

/*
Questions Marks
Have the function QuestionsMarks(str) take the str string parameter, which will contain single digit numbers, letters, and question marks, and check if there are exactly 3 question marks between every pair of two numbers that add up to 10. If so, then your program should return the string true, otherwise it should return the string false. If there aren't any two numbers that add up to 10 in the string, then your program should return false as well.

For example: if str is "arrb6???4xxbl5???eee5" then your program should return true because there are exactly 3 question marks between 6 and 4, and 3 question marks between 5 and 5 at the end of the string.
Examples
Input: "aa6?9"
Output: false
Input: "acc?7??sss?3rr1??????5"
Output: true
 */


public class QuestionsMarksCount {

  public static String QuestionsMarks(String str) {
    // code goes here  
    int digitCount = 0;
    int countQuestionMark = 0;
    String result = "false";
    List<Character> holder = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (Character.isDigit(ch)) {
        digitCount++;
      }
      if (digitCount > 0 && digitCount < 2) {
        holder.add(ch);
      }
      if (digitCount == 2) {
        for (Character c : holder) {
          if (c == '?') {
            countQuestionMark++;
          }
        }
      }
      if (countQuestionMark >= 3) {
        result = "true";
      }

    }

    return result;
  }

  public static void main(String[] args) {
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(QuestionsMarks(s.nextLine()));
  }
}
