package medium;

public class UniquePaths {
    public static void main(String[] args) {
        int m=3;
        int n=2;
        Solution62 test = new Solution62();
        int res = test.uniquePaths(m,n);
        System.out.println(res);

    }
}

class Solution62 {
    static int count=0;
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1) return 1;
        boolean[][] isVisited = new boolean[m][n];
        helper(isVisited,0,0);
        return count;
    }

    public void helper(boolean[][] isVisited, int i, int j){
        if(i==isVisited.length-1 && j==isVisited[0].length-1){
            count++;
            return;
        }
        if(i>=isVisited.length || j>=isVisited[0].length || isVisited[i][j]==true)
            return;
        isVisited[i][j]=true;
        helper(isVisited, i+1, j);
        helper(isVisited, i, j+1);
        isVisited[i][j]=false;
    }

    //Math
    public int uniquePathsSample(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }

        return (int)res;
    }

    //recursion with memo
    public int uniquePathsSample2(int m, int n) {
        return uniquePathsHelper(m - 1, n - 1, new int[n][m]);

    }

    private int uniquePathsHelper(int m, int n, int[][] memo) {
        if (m < 0 || n < 0) {
            return 0;
        } else if (m == 0 || n == 0) {
            return 1;
        } else if (memo[n][m] > 0) {
            return memo[n][m];
        } else {
            memo[n][m] = uniquePathsHelper(m - 1, n, memo) + uniquePathsHelper(m, n - 1, memo);
            return memo[n][m];
        }
    }

    //dp
    public int uniquePathsSample3(int m, int n) {
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) grid[0][j] = 1;
                if (j == 0) grid[i][j] = 1;
                if (i != 0 && j != 0) {
                    int up = grid[i - 1][j];
                    int left = grid[i][j - 1];
                    grid[i][j] = up + left;
                }
            }
        }
        return grid[n - 1][m - 1];
    }
}