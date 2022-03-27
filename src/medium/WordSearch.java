package medium;

public class WordSearch {
}

class Solution79 {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] isVisited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==word.charAt(0)){
                    if(findWord(board,word,0,i,j, isVisited))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean findWord(char[][] board, String word, int start, int i, int j, boolean[][] isVisited){
        if(start==word.length()){
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || isVisited[i][j] || board[i][j]!=word.charAt(start))
            return false;

        isVisited[i][j]=true;

        if(findWord(board, word, start+1, i+1,j, isVisited) ||findWord(board, word,start+1, i-1,j, isVisited) || findWord(board, word, start+1, i,j+1,isVisited) || findWord(board, word, start+1, i,j-1, isVisited))
            return true;
        isVisited[i][j]=false;
        return false;
    }

}