package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName PacificAtlanticWaterFlow
 * @Description TODO
 * @Author katefu
 * @Date 7/21/22 12:26 PM
 * @Version 1.0
 **/
public class PacificAtlanticWaterFlow {
}

class Solution417 {
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int n = heights.length, m = heights[0].length;
        if(heights==null || n==0 || m==0) return res;

        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();

        boolean[][] pVisited = new boolean[n][m];
        boolean[][] aVisited = new boolean[n][m];

        for(int i=0; i<n;i++){
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, m-1});
            pVisited[i][0] = true;
            aVisited[i][m-1] = true;
        }

        for(int j=0; j<m;j++){
            pQueue.offer(new int[]{0, j});
            aQueue.offer(new int[]{n-1, j});
            pVisited[0][j] = true;
            aVisited[n-1][j] = true;
        }

        bfs(heights, pQueue, pVisited);
        bfs(heights, aQueue, aVisited);

        for(int i=0;i<n; i++){
            for(int j=0; j<m; j++){
                if(pVisited[i][j] && aVisited[i][j]){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    res.add(tmp);
                }
            }
        }

        return res;
    }

    public void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited){
        int n = heights.length, m = heights[0].length;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] pos = queue.poll();
                for(int[] dir: dirs){
                    int x = pos[0]+dir[0];
                    int y = pos[1]+dir[1];
                    if(x<0 || y<0 || x>=n || y>= m || visited[x][y] || heights[x][y]<heights[pos[0]][pos[1]]) continue;
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }
}