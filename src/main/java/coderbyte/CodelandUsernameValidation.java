package coderbyte;

import java.util.*;
import java.io.*;

public class CodelandUsernameValidation {

  public static String CodelandUsernameValidation(String str) {
    // code goes here

    if(str.length()<4 || str.length()>5){
      return "false";
    }else if(!Character.isLetter(str.charAt(0))) {
      return "false";
    }else if(str.charAt(str.length()-1)=='_'){
      return "false";
    }else{
      for(int i=0; i<str.length(); i++){
        char ch=str.charAt(i);

        if(!Character.isLetter(ch) || !Character.isDigit(ch) || !(ch=='_')){
          return "false";
        }
      }
    }

    return "true";
  
  }

  public static void main (String[] args) {
    String s = "ABC12";


    Stack<String> sfd = new Stack<>();
    boolean isAlphaNumeric = s != null &&
            s.chars().allMatch(Character::isLetterOrDigit);
    System.out.println("IsAlphaNumeric: " + isAlphaNumeric);


    // if we use a stack, the output will be [1, 2, 3]
    Queue<Integer> myQ = new LinkedList<>();

    // if we use deque, output will be [3, 2, 1]
    // Deque<Integer> stack = new ArrayDeque<>();

    myQ.add(1);
    myQ.add(2);
    myQ.add(3);



    // 2. Using enhanced for-loop (uses Iterator internally)
    for (Integer item: myQ) {
      System.out.println(item);
    }


    // keep this function call here     
   // Scanner s = new Scanner(System.in);
    //System.out.print(CodelandUsernameValidation(s.nextLine()));
  }

}
