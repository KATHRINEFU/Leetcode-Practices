package dp;

import java.util.Arrays;

/**
 * @ClassName MinimumFallingPathSum
 * @Description
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 *
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly
 * below or diagonally left/right.
 * Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 * @Author katefu
 * @Date 6/7/22 10:26 AM
 * @Version 1.0
 **/
public class MinimumFallingPathSum {
}

class Solution931 {
    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int res = Integer.MAX_VALUE;
        dp = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], 66666);
        }
        for(int j=0; j<m; j++){
            res = Math.min(res, dp(matrix, n-1, j));
        }
        return res;
    }

    public int dp(int[][] matrix, int i, int j){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length) return 99999;
        if(i==0) return matrix[0][j];
        if (dp[i][j] != 66666) {
            return dp[i][j];
        }
        dp[i][j] = matrix[i][j]+minAmongThree(dp(matrix, i-1, j-1), dp(matrix, i-1,j), dp(matrix, i-1,j+1));
        return dp[i][j];
    }

    public int minAmongThree(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}
