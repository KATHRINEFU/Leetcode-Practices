package medium;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Kate Fu
 * @create: 2022-02-16 8:13
 */
public class Matrix01 {
    public static void main(String[] args) {
        int[][] input ={{0,0,0},{0,1,0},{1,1,1}};
        Solution524 test = new Solution524();
        int[][] res = test.updateMatrix(input);
        for(int i=0; i<res.length; i++){
            for(int j=0; j<res[0].length; j++){
                System.out.print(res[i][j]);
            }
            System.out.println();
        }

    }
}

class Solution524 {
    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        int[][] isVisited = new int[mat.length][mat[0].length];
        for(int i=0; i<res.length; i++){
            for(int j=0;j<res[0].length; j++){
                if(mat[i][j]==0) res[i][j]=0;
                else{
                    res[i][j] = findZeroDistance(mat, i, j, isVisited);
                }
            }
        }

        return res;
    }

    public int findZeroDistance(int[][] mat, int i, int j, int[][] isVisited){
        if(i<0 || i>=mat.length || j<0 || j>=mat[0].length || mat[i][j]==0 || isVisited[i][j]==1){
            if(i>=0 && i<mat.length && j>=0 && j<mat[0].length && isVisited[i][j]==1){
                for(int a=0; a<isVisited.length; a++){
                    for(int b=0; b<isVisited[0].length; b++){
                        isVisited[a][b]=0;
                    }
                }
            }
            return 0;
        }
        isVisited[i][j]=1;
         return 1+ Math.min(Math.min(findZeroDistance(mat, i+1, j, isVisited),findZeroDistance(mat,i-1,j, isVisited)), Math.min(findZeroDistance(mat, i, j+1, isVisited), findZeroDistance(mat, i, j-1,isVisited)));
    }

    //dynamic programming
    public int[][] updateMatrixSample(int[][] mat) {
        int m = mat.length, n = mat[0].length, INF = m + n; // The distance of cells is up to (M+N)
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 0) continue;
                int top = INF, left = INF;
                if (r - 1 >= 0) top = mat[r - 1][c];
                if (c - 1 >= 0) left = mat[r][c - 1];
                mat[r][c] = Math.min(top, left) + 1;
            }
        }
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (mat[r][c] == 0) continue;
                int bottom = INF, right = INF;
                if (r + 1 < m) bottom = mat[r + 1][c];
                if (c + 1 < n) right = mat[r][c + 1];
                mat[r][c] = Math.min(mat[r][c], Math.min(bottom, right) + 1);
            }
        }
        return mat;
    }

    //BFS
    public List<List<Integer>> updateMatrixSample2(List<List<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix.get(i).get(j) == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    matrix.get(i).set(j, Integer.MAX_VALUE);
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n ||
                        matrix.get(r).get(c) <= matrix.get(cell[0]).get(cell[1]) + 1) continue;
                queue.add(new int[] {r, c});
                matrix.get(r).set(c, matrix.get(cell[0]).get(cell[1]) + 1);
            }
        }

        return matrix;
    }
}

class Solution524Sample {
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length; // The distance of cells is up to (M+N)
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < m; ++r)
            for (int c = 0; c < n; ++c)
                if (mat[r][c] == 0) q.offer(new int[]{r, c});
                else mat[r][c] = -1; // Marked as not processed yet!

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for (int i = 0; i < 4; ++i) {
                int nr = r + DIR[i], nc = c + DIR[i+1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1) continue;
                mat[nr][nc] = mat[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        return mat;
    }
}