package basics;

import java.util.HashSet;

/**
 * @author: Kate Fu
 * @create: 2022-02-02 17:02
 */
public class ValidSudoku {

}

class Solution36 {
    public boolean isValidSudokuSample(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> square = new HashSet<>();
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'&&!row.add(board[i][j])) return false;
                if(board[i][j]!=','&&!col.add(board[j][i])) return false;
                int blockX = 3*(i/3);
                int blockY = 3*(i%3);
                int blockA = j/3;
                int blockB = j%3;
                if(board[blockX+blockA][blockY+blockB]!=','&&!square.add(board[blockX+blockA][blockY+blockB])) return false;
            }
        }
        return true;
    }
}