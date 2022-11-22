package leetCode;

public class ReverseString {

    public void reverseString(char[] s) {
        int start=0;
        int end=s.length-1;
        String str = "afasdf";
        char[] i= str.toCharArray();
        String.valueOf(i);
        while(start<=end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }

    }
}
