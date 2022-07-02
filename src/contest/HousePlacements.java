package contest;

import java.util.Arrays;

/**
 * @ClassName HousePlacements
 * @Description DP
 * There is a street with n * 2 plots, where there are n plots on each side of the street.
 * The plots on each side are numbered from 1 to n. On each plot, a house can be placed.
 *
 * Return the number of ways houses can be placed such that no two houses are adjacent to each other on the same side of the street.
 * Since the answer may be very large, return it modulo 10^9 + 7.
 * @Author katefu
 * @Date 7/1/22 12:50 PM
 * @Version 1.0
 **/
public class HousePlacements {
}

class Solution1{
    int mod = (int) (1e9+7);
    public int countHousePlacements(int n) {
        int[] dp = new int[n]; //one side
        Arrays.fill(dp, -1);
        helper(n-1, dp);
        return (int) ((1L * dp[n-1] * dp[n-1]) % mod);
    }

    public int helper(int i, int[] dp){
        if(i<0) return 1;
        if(dp[i]!=-1) return dp[i];
        int place = helper(i-2, dp);
        int notPlace = helper(i-1, dp);
        dp[i] = (place+notPlace)%mod;
        return dp[i];
    }

    //Fibo Sequence, O(logn)
    public int countHousePlacementsSample(int n) {
        int a = 1, b = 1, c = 2, mod = (int)1e9 + 7;
        for (int i = 0; i < n; ++i) {
            c = (a + b) % mod;
            a = b;
            b = c;
        }
        return (int)(1L * b * b % mod);
    }
}
