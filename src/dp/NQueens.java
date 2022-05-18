package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NQueens
 * @Description
 *    The n-queens puzzle is the problem of placing n queens on an n x n chessboard
 *    such that no two queens attack each other.
 *    Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 *    Each solution contains a distinct board configuration of the n-queens' placement,
 *    where 'Q' and '.' both indicate a queen and an empty space, respectively.
 * @Author katefu
 * @Date 5/17/22 2:49 PM
 * @Version 1.0
 **/
public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        Solution51 test  = new Solution51();
        test.solveNQueens(n);
    }
}

class Solution51 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        backTrack(board, 0);
        return res;
    }

    public void backTrack(char[][] board, int row){
        if(row==board.length){
            List<String> list = new ArrayList<>();
            for(int i=0; i<row; i++){
                String s = new String(board[i]);
                System.out.println(s);
                list.add(new String(board[i]));
            }
            res.add(list);
            return;
        }
        int n = board[0].length;
        for(int col=0; col<n; col++){
            if(!isValid(board, row, col)){
                continue;
            }
            board[row][col] = 'Q';
            backTrack(board, row+1);
            board[row][col] = '.';
        }
    }

    public boolean isValid(char[][] board, int row, int col){
        int n = board.length;
        for (int i = 0; i <= row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1;i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}
