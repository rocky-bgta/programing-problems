package leetCode;
/*
    https://leetcode.com/problems/transpose-matrix/
 */

/*
    Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:

Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]

 */

public class TransposeMatrix_867 {

    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        transpose(matrix);
    }

    /*
        https://www.youtube.com/watch?v=VDw9y6nX_ss
     */

    public static int[][] transpose(int[][] A){
        int rows = A.length; //take length of current matrix row
        int columns = A[0].length; // take length of current matrix column.

        int[][] new_matrix = new int[columns][rows];
        for(int row=0; row<rows; row++){
            for(int col=0; col<columns; col++){
                new_matrix[col][row] = A[row][col];
            }
        }
        return new_matrix;
    }

}
