package leetCode;

import java.util.HashMap;
import java.util.Map;

/*
    https://leetcode.com/problems/roman-to-integer/description/

 */

public class Roman_to_Integer_13 {

    public static void main(String[] args) {
     //   romanToInt("MCMXCIV");
        romanToInt("III");
    }



    public static int romanToInt(String s) {
        Map<Character,Integer> mapValue = new HashMap<>();
        mapValue.put('I',1);
        mapValue.put('V',5);
        mapValue.put('X',10);
        mapValue.put('L',50);
        mapValue.put('C',100);
        mapValue.put('D',500);
        mapValue.put('M',1000);

        int result = 0;
        int oneOperation;
        char[] chrArray = s.toCharArray();
        for(int i = chrArray.length-1; i>= 0; i--){
            oneOperation = i;
            if(i>0) {
                if (chrArray[i] == 'V' && chrArray[i - 1] == 'I') {
                    result += 4;
                    i--;
                } else if (chrArray[i] == 'X' && chrArray[i - 1] == 'I') {
                    result += 9;
                    i--;
                } else if (chrArray[i] == 'L' && chrArray[i - 1] == 'X') {
                    result += 40;
                    i--;
                } else if (chrArray[i] == 'C' && chrArray[i - 1] == 'X') {
                    result += 90;
                    i--;
                } else if (chrArray[i] == 'D' && chrArray[i - 1] == 'C') {
                    result += 400;
                    i--;
                } else if (chrArray[i] == 'M' && chrArray[i - 1] == 'C') {
                    result += 900;
                    i--;
                }
            }
            if(oneOperation==i) {
                result += mapValue.get(chrArray[i]);
            }

        }

        return result;
    }

}
