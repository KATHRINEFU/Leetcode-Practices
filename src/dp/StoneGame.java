package dp;

import java.util.Arrays;

/**
 * @ClassName StoneGame
 * @Description TODO
 * @Author katefu
 * @Date 6/22/22 11:21 AM
 * @Version 1.0
 **/
public class StoneGame {
}

class Solution877 {
    // dp(i,j): largest score for A in pile(i...j)
    int[][] memo;
    public boolean stoneGame(int[] piles) {
        int n = piles.length-1;
        memo = new int[n+1][n+1];
        for(int[] row: memo) Arrays.fill(row, -1);
        int total = 0;
        for(int i=0; i<n; i++) total+=piles[i];
        int aScore = dp(piles, 0, n);
        return aScore>total/2?true:false;
    }

    public int dp(int[] piles, int i, int j){
        if(i==j) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        int res = 0;
        res = Math.max(dp(piles, i+1, j)+piles[i], dp(piles, i, j-1)+piles[j]);
        memo[i][j] = res;
        return memo[i][j];
    }

    /*
    dp[i][j] means the biggest number of stones you can get more than opponent picking piles in piles[i] ~ piles[j].
    You can first pick piles[i] or piles[j].

    If you pick piles[i], your result will be piles[i] - dp[i + 1][j]
    If you pick piles[j], your result will be piles[j] - dp[i][j - 1]
    So we get:
    dp[i][j] = max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])
     */
    public boolean stoneGameSample(int[] p) {
        int n = p.length;
        int[][] dp  = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = p[i];
        for (int d = 1; d < n; d++)
            for (int i = 0; i < n - d; i++)
                dp[i][i + d] = Math.max(p[i] - dp[i + 1][i + d], p[i + d] - dp[i][i + d - 1]);
        return dp[0][n - 1] > 0;
    }
}
