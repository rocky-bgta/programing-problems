import java.text.DecimalFormat;

public class ValidPassword {

    public static void main(String[] args) {
      boolean result =  isValidPassword(new String("Passjjuyt#1!!!!!!!%!"));
        System.out.println(result);
    }

    public static Boolean isValidPassword(String password){

        boolean result = false;

        if(password.length() < 0)
            return false;

        for(char ch: password.toCharArray()){
            if(ch == ',' || ch==' ' || ch == '.')
                return false;
        }

        boolean hasUpperCases = false;
        boolean hasLowerCases = false;
        boolean hasDigits = false;
        int specialChars = 0;

        for(int i=0,n = password.length(); i<n; i++){
            char c = password.charAt(i);
            if(Character.isDigit(c)){
                hasDigits = true;
            }else if (Character.isUpperCase(c)){
                hasUpperCases = true;
            }else if(Character.isLowerCase(c)){
                hasLowerCases = true;
            }else if(c=='&' || c=='$' || c == '@' || c=='#' || c=='%' || c=='^' || c=='*' || c=='(' || c==')' ||c=='~' || c=='!') {
                specialChars++;
            }
        }

        if(hasUpperCases && hasLowerCases && hasDigits&&(specialChars>0)){
            result =  true;
        }

        /*
                To calculate the of x1 number
                x1/10*100
         */


        double percentage = ((double)specialChars / (double) password.length());
        DecimalFormat df = new DecimalFormat("#.#");
        percentage = Double.parseDouble(df.format(percentage));

        if(percentage > 0.2){
            result =  false;
        }

        for(int i=0; i<password.length()-3; i++){
            if(((int)password.charAt(i)+1) ==
                    (int)password.charAt(i+1) &&
                    ((int)password.charAt(i+2)+i) ==
                            (int)password.charAt(i+3) ){
                result =  false;
            }
        }

        return result;
    }
}
