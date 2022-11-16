package leetCode;
//https://leetcode.com/problems/transpose-matrix/
public class TransposeMatrix_867 {

    //https://www.youtube.com/watch?v=VDw9y6nX_ss
    public int[][] transpose(int[][] A){
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
