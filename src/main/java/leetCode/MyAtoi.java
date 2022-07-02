package leetCode;

public class MyAtoi {

    public static void main(String[] args) {
        String input = "+-12";
        myAtoi(input);
    }

    public static int myAtoi(String s) {
        s = s.trim();
        char charArray[] = s.toCharArray();
        int i=0;
        char sign=' ';
        int signCount=0;
        if(Character.isLetter(s.charAt(0))
                && s.charAt(0)!='-' && !Character.isDigit(s.charAt(0)))
            return 0;



        for(char c: charArray){
            if(Character.isDigit(c) || c=='.'){
                charArray[i]=c;
                i++;
            }else if(c=='-'){
                sign = c;
                signCount++;
            }else if (c=='+'){
                signCount++;
            }

        }

        if(signCount==2){
            return 0;
        }

        String integer;
        integer = new String(charArray,0,i);
        double result = new Double(integer);
        long l = (long) result;


        if(sign=='-'){
            l = -1*l;
        }

        // handle max and min
        if (l > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (l < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int)l;
    }
}
