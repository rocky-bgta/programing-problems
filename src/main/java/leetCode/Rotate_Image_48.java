package leetCode;

/*
    https://leetcode.com/problems/rotate-image/
 */
public class Rotate_Image_48 {

    public static void main(String[] args) {
      /* int matrix[][] = {
                            {5,1,9,11},
                            {2,4,8,10},
                            {13,3,6,7},
                            {15,14,12,16}
                        };*/

        int matrix[][] = {
                {2,   4, -1},
                {-10, 5, 11},
                {18, -7,  6},
        };

       Rotate_Image_48.rotate(matrix);
    }

    /*
        https://www.youtube.com/watch?v=SA867FvqHrM
     */

    public static void rotate(int[][] matrix){
        int length = matrix.length;
        // first turn all row  to column
        for(int row=0; row<length; row++){
            for(int col=row; col<length; col++){
                int temp = matrix[row][col];
                System.out.println("Temp value: " + temp);

                matrix[row][col] = matrix[col][row];
                System.out.println("Diagonal value: " +  matrix[col][row]);
                matrix[col][row] = temp;
            }
        }

        for(int i=0; i<length; i++){
            for(int j=0; j<(length/2); j++ ){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length-1-j];
                matrix[i][length-1-j] = temp;
            }
        }
    }
}
