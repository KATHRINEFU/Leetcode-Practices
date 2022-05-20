package dp;

/**
 * @ClassName BestTimeToBuyAndSellStock
 * @Description
 *     You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 *     You want to maximize your profit by choosing a single day to buy one stock and choosing a
 *     different day in the future to sell that stock.
 *
 *     Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * @Author katefu
 * @Date 5/20/22 3:57 PM
 * @Version 1.0
 **/
public class BestTimeToBuyAndSellStock {
}

class Solution121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i=0; i<n; i++){
            if(i-1==-1){
                dp[i][0]=0;
                dp[i][1]=-prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[n-1][0];
    }
}
