package dp;

/**
 * @ClassName BestTimeToBuyAndSellStock3
 * @Description within 2 times
 * @Author katefu
 * @Date 5/20/22 7:04 PM
 * @Version 1.0
 **/
public class BestTimeToBuyAndSellStock3 {
}

class Solution123 {
    public int maxProfit(int[] prices) {
        int max_k = 2, n = prices.length;
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            dp_i20 = Math.max(dp_i20, dp_i21 + prices[i]);
            dp_i21 = Math.max(dp_i21, dp_i10 - prices[i]);
            dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
            dp_i11 = Math.max(dp_i11, -prices[i]);
        }

        return dp_i20;
    }
}