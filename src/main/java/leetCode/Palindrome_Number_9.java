package leetCode;

public class Palindrome_Number_9 {


    public static void main(String[] args) {
        Integer result, inputNumber;
        inputNumber =  new Integer(125);
        result = inputNumber%10;
        System.out.println(result);

        isPalindrome(121);
    }

    public static boolean isPalindrome(int x) {

        int orginalNumber =x;
        if(x==0)
            return true;
        if(x<0 || x%10 == 0){
            return false;
        }

        int reversedInteger = 0;


        while(x>0){
            int pop = x%10;
            x=x/10;
            reversedInteger = (reversedInteger*10) + pop;
        }

        if(orginalNumber == reversedInteger){
            return true;
        }else {
            return false;
        }


    }

}



