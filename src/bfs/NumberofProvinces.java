package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName NumberofProvinces
 * @Description TODO
 * @Author katefu
 * @Date 6/4/23 7:25 PM
 * @Version 1.0
 **/
public class NumberofProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        Solution547 test = new Solution547();
        test.findCircleNum(isConnected);
    }
}

class Solution547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int res = 0;

        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            bfs(isConnected, visited, i);
            res++;
        }
        return res;
    }

    public void bfs(int[][] isConnected, boolean[] visited, int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        while(!queue.isEmpty()){
            int cur = queue.remove();
            for(int j=0; j<isConnected.length; j++){
                if(isConnected[cur][j]==1 && !visited[j]){
                    queue.add(j);
                    visited[j] = true;

                }
            }
        }
    }
}