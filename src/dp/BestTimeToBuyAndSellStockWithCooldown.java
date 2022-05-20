package dp;

/**
 * @ClassName BestTimeToBuyAndSellStockWithCooldown
 * @Description with cool down for one day
 * @Author katefu
 * @Date 5/20/22 4:53 PM
 * @Version 1.0
 **/
public class BestTimeToBuyAndSellStockWithCooldown {
}

class Solution309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i=0; i<n; i++){
            if(i-1==-1){
                dp[i][0]=0;
                dp[i][1]=-prices[i];
                continue;
            }

            if(i-2==-1){
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
                dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);
        }
        return dp[n-1][0];
    }
}
