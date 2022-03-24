package medium;

/**
 * @author: Kate Fu
 * @create: 2022-02-02 18:31
 */
public class Search2DMetrix {
    public static void main(String[] args) {
        int[][] input = {{1,3}};
        int target = 2;
        Solution74 test = new Solution74();
        boolean b = test.searchMatrix(input, target);
        System.out.println(b);
    }
}

class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length-1;
        int c = matrix[0].length-1;
        if(target<matrix[0][0] || target>matrix[r][c]) return false;
        int i = -1;
        for(int j=0; j<=r; j++){
            if(target==matrix[i+1][0]) return true;
            else if(target>matrix[i+1][0]) i++;
            else {
                break;
            }
        }

        int left=0;
        int right=c;
        int medium;

        while(left<=right){
            medium = (right-left)/2+left;
            if(target<matrix[i][medium]) right = medium-1;
            else if(target>matrix[i][medium]) left = medium+1;
            else return true;
        }

        return false;
    }

    public boolean searchMatrixSample(int[][] matrix, int target) {

        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int begin = 0, end = row_num * col_num - 1;

        while(begin <= end){
            int mid = (begin + end) / 2;
            int mid_value = matrix[mid/col_num][mid%col_num];

            if( mid_value == target){
                return true;

            }else if(mid_value < target){
                //Should move a bit further, otherwise dead loop.
                begin = mid+1;
            }else{
                end = mid-1;
            }
        }

        return false;
    }
}