package leetCode;

public class Add_Binary_67 {

    public static void main(String[] args) {

        String a = "11", b = "1";
        addBinary(a,b);
    }


    //https://www.youtube.com/watch?v=OEW50g03mT0
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;

        while (i>=0 || j >=0){
            int sum = carry;
            if(i >=0) {
                sum += a.charAt(i) - '0'; //convert char to number
            }
            if(j >=0)
                sum+=b.charAt(j) - '0';
            sb.append(sum % 2); // if sum is 2 this operation result 0 and append to the  spring
            carry = sum/2; // if sum = 2 then sum/2 result 1 which is carry

            i--;
            j--;
        }
        if(carry!=0) sb.append(carry); // because its append result link 0001 so need to reverse it
        return sb.reverse().toString();
    }
}
