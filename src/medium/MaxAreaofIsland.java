package medium;

/**
 * @author: Kate Fu
 * @create: 2022-02-15 13:33
 */
public class MaxAreaofIsland {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        Solution695 test = new Solution695();
        int res = test.maxAreaOfIsland(grid);
        System.out.println(res);
    }
}

class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i = 0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1)
                    max = Math.max(max,traverse(grid, i, j));
            }
        }
        return max;
    }

    public int traverse(int[][] grid, int i, int j){

        if(i<0 || i>=grid.length || j<0|| j>=grid[0].length || grid[i][j]!=1){
            return 0;
        }

        grid[i][j]=0;
        return 1+traverse(grid, i+1, j)+traverse(grid, i-1, j)+traverse(grid, i, j+1)+traverse(grid, i, j-1);

    }

    public int AreaOfIsland(int[][] grid, int i, int j){
        if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + AreaOfIsland(grid, i+1, j) + AreaOfIsland(grid, i-1, j) + AreaOfIsland(grid, i, j-1) + AreaOfIsland(grid, i, j+1);
        }
        return 0;
    }
}