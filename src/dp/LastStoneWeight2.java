package dp;

/**
 * @ClassName LastStoneWeight2
 * @Description
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * We are playing a game with the stones. On each turn, we choose any two stones and smash them together.
 * Suppose the stones have weights x and y with x <= y. The result of this smash is:
 *
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 *
 * Return the smallest possible weight of the left stone. If there are no stones left, return 0.
 * @Author katefu
 * @Date 6/15/22 11:26 AM
 * @Version 1.0
 **/
public class LastStoneWeight2 {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        Solution1049 test = new Solution1049();
        test.lastStoneWeightII(stones);
    }
}

class Solution1049 {
    public int lastStoneWeightII(int[] stones) {
        int sumTotal=0;
        int n = stones.length;
        for(int i=0; i<n; i++){
            sumTotal+=stones[i];
        }
        int sum = sumTotal/2;
        int[][] dp = new int[n+1][sum+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(j<stones[i-1]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stones[i-1]]+stones[i-1]);
            }
        }
        return sumTotal - dp[n][sum]*2;
    }

    // compressed dp array
    public int lastStoneWeightIISample(int[] stones) {
        int n = stones.length, sum = 0;
        for (int s : stones) sum += s;
        int[] dp = new int[sum / 2 + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = sum / 2; j >= stones[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i - 1]] + stones[i - 1]);
            }
        }
        return sum - 2 * dp[sum / 2];
    }
}


