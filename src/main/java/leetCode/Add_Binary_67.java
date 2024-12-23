package leetCode;

//https://leetcode.com/problems/add-binary/description/

public class Add_Binary_67 {

    public static void main(String[] args) {
        String a = "11", b = "1";
        System.out.println(addBinary(a, b)); // Add two binary strings and print the result
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder(); // To build the resulting binary string
        int i = a.length() - 1; // Start from the last character of string `a`
        int j = b.length() - 1; // Start from the last character of string `b`
        int carry = 0; // To keep track of the carry in addition

        // Iterate through both strings until all characters and carry are processed
        while (i >= 0 || j >= 0) {
            int sum = carry; // Initialize `sum` with the carry from the previous addition

            // Add the digit from string `a` if `i` is within bounds
            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Convert char to number (e.g., '1' -> 1, '0' -> 0)
                i--; // Move to the next digit on the left
            }

            // Add the digit from string `b` if `j` is within bounds
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // Convert char to number
                j--; // Move to the next digit on the left
            }

            // Append the current binary digit (sum % 2) to the result
            sb.append(sum % 2); // Binary addition: 0 + 0 = 0, 1 + 0 = 1, 1 + 1 = 10 (write 0, carry 1)

            // Update the carry for the next iteration
            carry = sum / 2; // Binary carry: 0, 1 (no carry) or 2 (carry = 1)
        }

        // If there's any carry left after processing all digits, append it
        if (carry != 0) {
            sb.append(carry);
        }

        // Since we built the result from right to left, reverse it to get the final answer
        return sb.reverse().toString();
    }
}
