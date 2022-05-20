package dp;

/**
 * @ClassName BestTimeToBuyAndSellStockWithFee
 * @Description with transaction fee
 * @Author katefu
 * @Date 5/20/22 5:10 PM
 * @Version 1.0
 **/
public class BestTimeToBuyAndSellStockWithFee {
}

class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i=0; i<n; i++){
            if(i-1==-1){
                dp[i][0]=0;
                dp[i][1]=-prices[i]-fee;
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]-fee);
        }
        return dp[n-1][0];
    }
}