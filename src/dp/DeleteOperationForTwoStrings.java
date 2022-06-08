package dp;

import java.util.Arrays;

/**
 * @ClassName DeleteOperationForTwoStrings
 * @Description TODO
 * @Author katefu
 * @Date 6/8/22 12:07 PM
 * @Version 1.0
 **/
public class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        String s = "vfdavfda";

        System.out.println(s.substring(0,1));
    }
}

class Solution583 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;

        // dp[i][j] stands for distance of first i chars of word1 and first j chars of word2
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++)
            dp[i][0] = i;
        for (int j = 0; j <= len2; j++)
            dp[0][j] = j;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + 2, dp[i - 1][j] + 1), dp[i][j - 1] + 1);
            }
        }

        return dp[len1][len2];
    }

    // time limit exceed
    int[][] dp;
    public int minDistanceMine(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m==0) return n;
        if(n==0) return m;
        dp = new int[m+1][n+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return dp(word1,word2, m, n);
    }

    public int dp(String word1, String word2, int i, int j){
        if(i<=0) return j;
        if(j<=0) return i;

        if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i-1)==word2.charAt(j-1)) return dp(word1, word2, i-1, j-1);
        return minAmongThree(dp(word1, word2, i-1, j-1)+2, dp(word1, word2, i, j-1)+1, dp(word1, word2, i-1, j)+1);
    }

    public int minAmongThree(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }
}
