package medium;
/*
Given an m x n 2D binary grid, which represents a map of '1's (land) and '0's (water),
return the number of islands.
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        Solution200 test = new Solution200();
        int res = test.numIslands(grid);
        System.out.println(res);
    }
}

class Solution200 {
    public int numIslands(char[][] grid) {
        boolean[][] isVisited=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='0' || isVisited[i][j]==true) continue;
                if(BFS(grid, i,j,isVisited)>0) count++;
            }
        }
        return count;
    }

    public int BFS(char[][] grid, int row, int col, boolean[][] isVisited){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || isVisited[row][col]==true || grid[row][col]=='0'){
            return 0;
        }
        isVisited[row][col]=true;
        return 1+(BFS(grid,row+1,col,isVisited)+BFS(grid,row-1,col,isVisited) +BFS(grid,row,col+1, isVisited) +BFS(grid, row, col-1, isVisited));
    }
}
