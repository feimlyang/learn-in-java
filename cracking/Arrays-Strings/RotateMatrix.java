/**
 * RotateMatrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class RotateMatrix {

    public static void rotateMatrix(int[][] matrix){
         int n = matrix.length;
         int endIndex = n % 2 == 0 ? n/2 - 1 : (n-1)/2 - 1;
         int temp;
         //start at anolog by anology
         for (int i = 0; i <= endIndex; i++ ){
             for (int j = i; j < n-i-1; j++){
                 temp = matrix[i][j];
                 matrix[i][j] = matrix[n-j-1][i];
                 matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                 matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                 matrix[j][n-i-1] = temp;
             }
         }

    }

    public static void matrixToString(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        matrixToString(matrix1);
        rotateMatrix(matrix1);
        matrixToString(matrix1);

        int[][] matrix2 = {{1,2,3,4},{4,5,6,7},{7,8,9,1},{3,4,5,6}};
        matrixToString(matrix2);
        rotateMatrix(matrix2);
        matrixToString(matrix2);

    }

    
}