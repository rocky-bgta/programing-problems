package leetCode;

public class RemoveAllAdjacentDuplicate {

    public static void main(String[] args) {

        String s="abb  aca";

        char[] stack = new char[s.length()];
        int i = 0;

        for(int j=0; j<s.length(); j++){
            char current_char = s.charAt(j);

            if(i>0 && stack[i-1]==current_char){
                i--;
            }else {
                stack[i] = current_char;
                i +=1;
            }
        }

        String resutl = new String(stack, 0,i);

        System.out.printf("result "+ resutl);

    }
}
