package array;

/**
 * @ClassName RangeSumQuery2D
 * @Description Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner
 * (row1, col1) and lower right corner (row2, col2).
 * @Author katefu
 * @Date 5/15/22 6:53 PM
 * @Version 1.0
 **/
public class RangeSumQuery2D {
}

class Solution304 {
    int[][] preSum;
    public Solution304(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if(m==0 || n==0) return;
        preSum = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i - 1][j - 1] - preSum[i-1][j-1];
            }
        }
    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1]-preSum[row1][col2+1]-preSum[row2+1][col1]+preSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */