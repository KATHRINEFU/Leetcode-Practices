package basics;

public class BestTimeBuySell {

}

class Solution1211 {

    //array
    public int maxProfit(int[] prices) {
        if(prices.length==1) return 0;
        int buy = Integer.MAX_VALUE;
        int max = 0;
        int temp = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i]<buy){
                buy = prices[i];
            }
            temp = prices[i]-buy;
            max = max>temp?max:temp;
        }

        return max;
    }

    //dynamic programming
    public int maxProfitSample(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        // Space: O(n)
        int[] maxSell = new int[n];
        maxSell[n-1] = prices[n-1];

        // Time: O(n)
        for (int i = n-2; i >= 0; i--) {
            maxSell[i] = Math.max(maxSell[i+1], prices[i]);
        }

        int maximum = 0;
        for (int i = 0; i < n; i++) {
            maximum = Math.max(maxSell[i] - prices[i], maximum);
        }

        return maximum;
    }

    //kadane's algorithm
    public int maxProfitSample2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int globalMax = 0;
        int localMax = 0;
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i-1];
            localMax = Math.max(diff, localMax+diff);
            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }
}
