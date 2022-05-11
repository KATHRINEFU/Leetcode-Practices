package array;

/**
 * @ClassName RotateImage
 * @Description TODO
 * @Author katefu
 * @Date 5/10/22 11:45 AM
 * @Version 1.0
 **/
public class RotateImage {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        Solution48 test = new Solution48();
        test.rotate(mat);

    }
}

class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<(n+1)/2; i++){
            for(int j=0; j<n/2; j++){
                int temp = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
