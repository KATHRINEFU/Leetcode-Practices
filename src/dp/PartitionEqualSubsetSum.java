package dp;

/**
 * @ClassName PartitionEqualSubsetSum
 * @Description Given a non-empty array nums containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * @Author katefu
 * @Date 6/14/22 11:15 AM
 * @Version 1.0
 **/
public class PartitionEqualSubsetSum {
}

class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        int n = nums.length;
        sum = sum/2;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i <= n; i++) dp[i][0] = true;
        for(int i=1; i<=n; i++){
            for(int w=1; w<=sum;w++){
                if(w<nums[i-1]) dp[i][w] = dp[i-1][w];
                else{
                    dp[i][w] = dp[i-1][w] || dp[i-1][w-nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}