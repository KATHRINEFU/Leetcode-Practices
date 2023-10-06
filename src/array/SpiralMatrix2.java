package array;

/**
 * @ClassName SpiralMatrix2
 * @Description TODO
 * @Author katefu
 * @Date 9/26/23 10:38 PM
 * @Version 1.0
 **/
public class SpiralMatrix2 {
}

class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n-1, top = 0, bottom = n-1;
        int count = 0;
        while(count < n*n){
            for(int i=left; i<=right && count<n*n; i++)
                matrix[top][i] = ++count;
            for(int i = top+1; i<bottom && count<n*n; i++){
                matrix[i][right] = ++count;
            }
            for(int i= right; i>=left && count<n*n; i--){
                matrix[bottom][i] = ++count;
            }
            for(int i=bottom-1; i>top && count<n*n; i--){
                matrix[i][left] = ++ count;
            }
            left ++;
            right --;
            top ++;
            bottom --;
        }
        return matrix;
    }
}