package leetCode.sliding_window;

public class SubstringCombinations {

    public static void main(String[] args) {
        String input = "ab";
        generateSubstringCombinations(input);
    }

    public static void generateSubstringCombinations(String input) {
        if (input == null || input.length() == 0) {
            System.out.println("Invalid input.");
            return;
        }

        System.out.println("Input: " + input);

        // Iterate for different window sizes
        for (int windowSize = 1; windowSize <= input.length(); windowSize++) {
            System.out.println("\nWindow Size: " + windowSize);

            // Start sliding window
            for (int startIndex = 0; startIndex <= input.length() - windowSize; startIndex++) {
                int endIndex = startIndex + windowSize;

                // Print the substring for the current window
                for (int i = startIndex; i < endIndex; i++) {
                    System.out.print(input.charAt(i) + " ");
                }

                System.out.println();
            }
        }
    }
}
/*
    If you omit the windowSize in the condition startIndex <= input.length() - windowSize, it means you are not considering the size of the window when sliding through the input string. This can lead to indexing issues and may result in accessing characters outside the valid range.

Let's consider an example:

Suppose you have an input string "abcd" and you are sliding a window of size 2 through it. Without considering the window size in the condition, the loop would be:

java
Copy code
for (int startIndex = 0; startIndex <= input.length(); startIndex++) {
    int endIndex = startIndex + windowSize;
    // Process the substring [startIndex, endIndex)
}
In this case, when startIndex reaches the value input.length(), endIndex will be input.length() + windowSize, and you'll attempt to access characters beyond the end of the string, resulting in an IndexOutOfBoundsException.

To avoid such issues and ensure the window stays within the bounds of the string, it's crucial to consider the window size in the condition:

java
Copy code
for (int startIndex = 0; startIndex <= input.length() - windowSize; startIndex++) {
    int endIndex = startIndex + windowSize;
    // Process the substring [startIndex, endIndex)
}
This ensures that endIndex does not go beyond the valid range of indices in the input string.
 */
