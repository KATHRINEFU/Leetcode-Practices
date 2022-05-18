package dp;

/**
 * @ClassName CoinChange
 * @Description TODO
 * @Author katefu
 * @Date 5/17/22 10:58 AM
 * @Version 1.0
 **/
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int target = 100;
        Solution322 test = new Solution322();
        int res = test.coinChange(coins,target);
        System.out.println(res);
    }
}

class Solution322 {
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    public int dp(int[] coins, int amount){
        if(amount==0) return 0;
        if(amount<0) return -1;
        int res = Integer.MAX_VALUE;
        for(int coin:coins){
            int sub = dp(coins, amount-coin);
            if(sub==-1) continue;
            res = Math.min(res, sub+1);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }

    public int coinChangeSample(int[] coins, int amount) {
        if(amount<1) return 0;
        return helper(coins, amount, new int[amount]);
    }

    private int helper(int[] coins, int amount, int[] count) {
        if(amount<0) return -1; // not valid
        if(amount==0) return 0; // completed
        if(count[amount-1] != 0) return count[amount-1]; // already computed, so reuse
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int res = helper(coins, amount-coin, count);
            if(res>=0 && res < min)
                min = 1+res;
        }
        count[amount-1] = (min==Integer.MAX_VALUE) ? -1 : min;
        return count[amount-1];
    }
}
