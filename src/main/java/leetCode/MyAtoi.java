package leetCode;

/*
    https://leetcode.com/problems/string-to-integer-atoi/description/
 */

public class MyAtoi {

    public static void main(String[] args) {
        //String input = "   -42";
        String input = "00000-42a1234";
        myAtoi(input);
    }

    public static int myAtoi(String s) {
        if (s == null || s == "")
            return 0;
        s = s.trim(); // remove whitespace
        char[] charArray = s.toCharArray(); // convert to character array
        int i = 0;
        char sign = ' ';
        int signCount = 0;

        if (s.length() > 0) {
            if (s.charAt(0) == '+' && s.length() == 1)
                return 0;

            if (s.charAt(0) == '-' && s.length() == 1)
                return -0;

            if (charArray.length == 0)
                return 0;

            if (Character.isLetter(s.charAt(0)) // that is abc..z
                    && s.charAt(0) != '-' && !Character.isDigit(s.charAt(0)))
                return 0;


            for (char c : charArray) {
                if (Character.isDigit(c) || c == '.') {
                    charArray[i] = c;
                    i++;
                } else if (c == '-') {
                    sign = c;
                    signCount++;
                } else if (c == '+') {
                    signCount++;
                }

            }

            if (signCount == 2) {
                return 0;
            }

            String integer;
            long l;
            integer = new String(charArray, 0, i);
            if (integer != null) {
                double result = new Double(integer);
                l = (long) result;
            } else {
                return 0;
            }


            if (sign == '-') {
                l = -1 * l;
            }

            // handle max and min
            if (l > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (l < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            return (int) l;
        } else {
            return 0;
        }
    }
}
