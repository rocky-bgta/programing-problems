package hackerRank;
/*
   move all zero to right
   MDS question
 */


public class MoveAllZeroToRight {

    public static void main(String[] args) {

        int ar[] = {1, 0, 8, 9, 0, 7, 2, 0};
        int j;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == 0) {
                j = i;
                while (j < ar.length-1) {
                    ar[j] = ar[j + 1];
                    ar[ar.length - 1] = 0;
                    j++;
                }
            }
        }

        for (int item : ar) {
            System.out.print(item + " ");
        }

    }
}
