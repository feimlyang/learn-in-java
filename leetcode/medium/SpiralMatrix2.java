/* 
59. Spiral Matrix II

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Note: Traverse Matrix O(mn)

*/

class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int[][] matrix = new int[n][n];
        int target = n * n;
        int count = 1;

        while (count <= target) {
            //left to right, top can be traversed by a row
            for (int j = left; j <= right; j++) matrix[top][j] = count++;
            top++;

            //top to bottom, right can be traversed by a col
            for (int i = top; i <= bottom; i++) matrix[i][right] = count++;
            right--;

            //right to left, bottom can be traversed by a row
            for (int j = right; j >= left; j--) matrix[bottom][j] = count++;
            bottom--;
            
            //bottom to top, left can be traversed by a col
            for (int i = bottom; i >= top; i--) matrix[i][left] = count++;
            left++;
        }
        return matrix;
    }
}