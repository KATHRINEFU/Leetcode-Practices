package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName RottingOranges
 * @Description TODO
 * @Author katefu
 * @Date 7/21/22 10:43 AM
 * @Version 1.0
 **/
public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        Solution994 test = new Solution994();
        test.orangesRotting(grid);
    }
}

class Solution994 {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int countFresh = 0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==2) queue.offer(new int[]{i,j});
                else if(grid[i][j]==1) countFresh++;
            }
        }
        if(countFresh==0) return 0;
        int res = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            res++;
            int size = queue.size();
            for(int i=0;i<size; i++){
                int[] pos = queue.poll();
                for(int j=0; j<dirs.length; j++){
                    int x = pos[0]+dirs[j][0];
                    int y = pos[1]+dirs[j][1];
                    if(x < 0 || y < 0 || x >= rows || y >= cols) continue;
                    if(grid[x][y]==1){
                        countFresh--;
                        grid[x][y]=2;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
            if(countFresh<=0) return res;
        }

        return countFresh <= 0 ? res-1 : -1;
    }
}