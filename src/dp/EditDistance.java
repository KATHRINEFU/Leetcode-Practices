package dp;

import java.util.Arrays;

/**
 * @ClassName EditDistance
 * @Description TODO
 * @Author katefu
 * @Date 6/7/22 7:22 PM
 * @Version 1.0
 **/
public class EditDistance {
}

class Solution72 {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        memo = new int[m][n];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
        return dp(word1, m-1, word2, n-1);
    }

    public int dp(String s1, int i, String s2, int j){
        if(i==-1) return j+1;
        if(j==-1) return i+1;
        if(memo[i][j]!=-1) return memo[i][j];
        if(s1.charAt(i)==s2.charAt(j)) memo[i][j]= dp(s1,i-1, s2, j-1);
        else memo[i][j] =  minAmongThree(dp(s1, i, s2, j-1)+1, dp(s1, i-1, s2,j)+1, dp(s1, i-1, s2, j-1)+1);
        return memo[i][j];
    }


    public int minAmongThree(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }
    public int minDistanceSample(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)
            cost[i][0] = i;
        for(int i = 1; i <= n; i++)
            cost[0][i] = i;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[m][n];
    }
}
