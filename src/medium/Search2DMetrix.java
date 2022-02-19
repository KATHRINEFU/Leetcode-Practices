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
        int rows = matrix.length-1;
        int cols = matrix[0].length-1;
        if(target<matrix[0][0] || target >matrix[rows][cols]) return false;
        if(cols==0){
            int left=0;
            int right = rows;
            int middle=0;
            while(left<=right){
                middle = (left+right)/2;
                if(matrix[middle][0]==target) return true;
                if(matrix[middle][0]>target){
                    right = middle-1;
                }
                if(matrix[middle][0]<target){
                    left = middle+1;
                }
            }

            return false;
        }

        if(rows==0){
            int left=0;
            int right = cols;
            int middle=0;
            while(left<=right){
                middle = (left+right)/2;
                if(matrix[middle][0]==target) return true;
                if(matrix[middle][0]>target){
                    right = middle-1;
                }
                if(matrix[middle][0]<target){
                    left = middle+1;
                }
            }

            return false;
        }
        int up = 0;
        int buttom = rows;
        int index=0;
        while(up<=buttom){
            index = (up+buttom)/2;
            if(matrix[index][0]==target) return true;
            if(buttom-up==1) {
                index=up;
                break;
            }

            if(matrix[index][0]>target){
                buttom = index;
            }
            if(matrix[index][0]<target){
                up = index;
            }
        }

        int left=0;
        int right = cols;
        int middle=0;
        while(left<=right){
            middle = (left+right)/2;
            if(matrix[index][middle]==target) return true;
            if(matrix[index][middle]>target){
                right = middle-1;
            }
            if(matrix[index][middle]<target){
                left = middle+1;
            }
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