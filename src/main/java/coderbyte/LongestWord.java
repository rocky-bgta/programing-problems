package coderbyte;

import java.util.*;
import java.io.*;
/*
Have the function LongestWord(sen) take the sen parameter being passed and return
the longest word in the string. If there are two or more words that are the same length,
 return the first word from the string with that length.
 Ignore punctuation and assume sen will not be empty. Words may also contain numbers,
 for example "Hello world123 567"
 */


public class LongestWord {

  private static class WordLength{
    public String word;
    public Integer length;
    WordLength(String word, Integer length){
      this.word = word;
      this.length = length;
    }
  }

  public static String LongestWord(String sen) {
    // code goes here  
    int max=-1;
    Queue<WordLength> que = new LinkedList<>();

    String words[] = sen.split(" ");
    for (String word: words) {
      if(word.chars().allMatch(Character::isLetterOrDigit)){
        que.add(new WordLength(word,word.length()));
        if(word.length()>max)
          max=word.length();
      }
    }

    String result="";
    for (WordLength item: que) {
      if(item.length==max){
        result = item.word;
        break;
      }

    }
    return result;
  }

  public static void main (String[] args) {  
    // keep this function call here
    String sfg = "I love dogs";
    LongestWord(sfg);
   // Scanner s = new Scanner(System.in);
    //System.out.print(LongestWord(s.nextLine()));
  }

}
