package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName SumOfNumbersWithUnitsDigitK
 * @Description
 * Given two integers num and k, consider a set of positive integers with the following properties:
 *
 * The units digit of each integer is k.
 * The sum of the integers is num.
 * Return the minimum possible size of such a set, or -1 if no such set exists.
 *
 * Note:
 *
 * The set can contain multiple instances of the same integer, and the sum of an empty set is considered 0.
 * The units digit of a number is the rightmost digit of the number.
 * @Author katefu
 * @Date 7/3/22 11:09 AM
 * @Version 1.0
 **/
public class SumOfNumbersWithUnitsDigitK {
}

class Solution4 {
    public int minimumNumbers(int num, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= num; i++){
            if (i % 10 == k){
                list.add(i);
            }
        }
        int[] nums = list.stream().mapToInt(i->i).toArray();
        return coinChange(nums, num);
    }

    public int coinChange(int[] coins, int amount) {
        int[]dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;

        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(coin>i)continue;
                dp[i]=Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}