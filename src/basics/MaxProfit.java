package basics;

/**
 * @author: Kate Fu
 * @create: 2022-01-29 20:25
 */
public class MaxProfit {
  public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        Solution121 test = new Solution121();
        int i = test.maxProfit(a);
        System.out.println(i);
  }
}

class Solution121 {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int buy=0;
        int sell = prices.length-1;
        int maxProfit=0;
        int num=0;
        while(buy<sell){
            int res = prices[sell]-prices[buy];
            if(res>maxProfit){
                maxProfit = res;
            }
            if(num%2==0) buy++;
            else sell--;
            num++;
        }
        return maxProfit;
    }

    public int maxProfitSample(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            else if (prices[i] > min) max = Math.max(prices[i] - min, max);
        }
        return max;
    }
}