package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName PathWithMinimumEffort
 * @Description
 * You are a hiker preparing for an upcoming hike.
 * You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height
 * of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right
 * cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find
 * a route that requires the minimum effort.
 *
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 *
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 * @Author katefu
 * @Date 6/13/22 11:26 AM
 * @Version 1.0
 **/
public class PathWithMinimumEffort {
}

class Solution1631 {
    class State {
        int x, y;
        int effortFromStart;

        State(int x, int y, int effortFromStart) {
            this.x = x;
            this.y = y;
            this.effortFromStart = effortFromStart;
        }
    }

    int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] effortTo = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        effortTo[0][0]=0;
        PriorityQueue<State> pq = new PriorityQueue<>((a, b)->{
            return a.effortFromStart-b.effortFromStart;
        });
        pq.offer(new State(0,0,0));
        while(!pq.isEmpty()){
            State curState = pq.poll();
            int curX = curState.x;
            int curY = curState.y;
            int curEffort = curState.effortFromStart;
            if (curX == m - 1 && curY == n - 1) return curEffort;
            if(curEffort>effortTo[curX][curY]) continue;
            for(int[] neighbors: adj(heights,curX,curY)){
                int neiX = neighbors[0];
                int neiY = neighbors[1];
                int newEffort =Math.max(effortTo[curX][curY], Math.abs(heights[neiX][neiY] - heights[curX][curY]));
                if(newEffort<effortTo[neiX][neiY]){
                    effortTo[neiX][neiY] = newEffort;
                    pq.offer(new State(neiX, neiY, newEffort));
                }
            }
        }
        return effortTo[m-1][n-1];
    }

    public List<int[]> adj(int[][] matrix, int x, int y){
        List<int[]> neighbors = new ArrayList<>();
        for(int[] dir: dirs){
            int neiX = x+dir[0];
            int neiY = y+dir[1];
            if(neiX<0 || neiX>=matrix.length || neiY<0|| neiY>=matrix[0].length) continue;
            neighbors.add(new int[]{neiX, neiY});
        }
        return neighbors;
    }
}
