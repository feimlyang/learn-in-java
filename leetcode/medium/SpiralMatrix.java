
/* 54. Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order. 
*/

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;

        while (true) {
            for (int j = left; j <= right; j++) res.add(matrix[top][j]);
            top++;
            if (top > bottom) break;

            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            if (right < left) break;

            for (int j = right; j >= left; j--) res.add(matrix[bottom][j]);
            bottom--;
            if (bottom < top) break;

            for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
            if (left > right) break;

        }
        return res;
    }
}