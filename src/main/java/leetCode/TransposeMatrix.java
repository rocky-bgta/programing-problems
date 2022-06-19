package leetCode;

public class TransposeMatrix {

    public int[][] transpose(int[][] A){
        int rows = A.length;
        int columns = A[0].length;

        int[][] new_matrix = new int[columns][rows];
        for(int row=0; row<rows; row++){
            for(int col=0; col<columns; col++){
                new_matrix[col][row] = A[row][col];
            }
        }
        return new_matrix;
    }

}
