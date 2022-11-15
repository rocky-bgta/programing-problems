package japan;

public class CodeSignalTest {

    public static void main(String[] args) {
      int n = 29;
      solution(n);
    }

    static int solution(int n) {
        String number = new Integer(n).toString();
        int firstChar =Integer.parseInt(String.valueOf(number.charAt(0)));
        int lastChar = Integer.parseInt(String.valueOf(number.charAt(number.length()-1)));
        int result = firstChar + lastChar;

        return result;
    }

}
