package hackerRank;
/*
   move all zero to right
   MDS question
 */


public class MoveAllZeroToRight {
    public static void main(String[] args) {
        int ar[] = {1, 0, 8, 9, 0, 7, 2, 0};
        int pos = 0; // Points to the position where the next non-zero should go

        // Move non-zero elements to the left
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] != 0) {
                ar[pos++] = ar[i];
            }
        }

        // Fill the rest of the array with zeros
        while (pos < ar.length) {
            ar[pos++] = 0;
        }

        // Print the result
        for (int item : ar) {
            System.out.print(item + " ");
        }
    }
}

