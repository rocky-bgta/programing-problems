package coderbyte;

import java.util.*;

public class FindIntersection {

  public static String FindIntersection(String[] strArr) {
    // code goes here  
    String result="";
    String str1 = strArr[0];
    String str2 = strArr[1];

    String[] strOnlyChar1 = str1.split(",");
    String[] strOnlyChar2 = str2.split(",");

    System.out.println(Arrays.toString(strOnlyChar1));

    Map<String,String> map = new HashMap<>();
    for(String s: strOnlyChar1){
      //System.out.print(s);
      map.put(s,s);
    }

    for(String c: strOnlyChar2){
      if(map.containsKey(c)){
        result+=c+",";
      }
    }

    result = result.substring(0,result.length()-1);

    return result;
  }

  public static void main (String[] args) {
    // keep this function call here     
   // Scanner s = new Scanner(System.in);
    //System.out.print(FindIntersection(s.nextLine()));
  }

}
