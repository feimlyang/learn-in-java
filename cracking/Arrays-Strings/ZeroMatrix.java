/**
 * ZeroMatrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.
 */
public class ZeroMatrix {
    //space O(1) solution
    public static void setZeros(int[][] matrix){
        boolean benchmarkRowHasZero = false, benchmarkColHasZero = false;
        //let benchmark to be 0th row and col
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                benchmarkColHasZero = true;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; j++){
            if (matrix[0][j] == 0){
                benchmarkRowHasZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int j = 1; j < matrix[0].length; j++){
            if (matrix[0][j] == 0) nullifyCol(matrix, j);
        }
        for (int i = 1; i < matrix.length; i++){
            if (matrix[i][0] == 0) nullifyRow(matrix, i);
        }

        if (benchmarkColHasZero) nullifyCol(matrix, 0);
        if (benchmarkRowHasZero) nullifyRow(matrix, 0);
    }

    public static void nullifyRow(int[][] matrix, int row){
        for (int j = 0; j < matrix[row].length; j++){
            matrix[row][j] = 0;
        }
    }
    public static void nullifyCol(int[][] matrix, int col){
        for (int i = 0; i < matrix.length; i++){
            matrix[i][col] = 0;
        }
    }

    public static void matrixToString(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] matrix1 = {{1,1,1,1}, {1,1,0,1}};
        matrixToString(matrix1);
        setZeros(matrix1);
        matrixToString(matrix1);

        int[][] matrix2 = {{1,1,1,1,0}, {1,1,0,1,1}, {1,1,1,1,1}, {1,1,1,1,1}, {1,1,1,1,0}};
        matrixToString(matrix2);
        setZeros(matrix2);
        matrixToString(matrix2);
        
    }
    
}