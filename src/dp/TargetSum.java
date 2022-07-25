package dp;

import java.util.HashMap;

/**
 * @ClassName TargetSum
 * @Description
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-'
 * before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and
 * concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 * @Author katefu
 * @Date 6/7/22 11:39 AM
 * @Version 1.0
 **/
public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        Solution494 test = new Solution494();
        test.find(nums, target);
    }
}

class Solution494 {
    int result=0;

    //backtracking
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length==0) return 0;
        backtrack(nums, 0, target);
        return result;
    }

    public void backtrack(int[] nums, int i, int remain){
        if(i==nums.length){
            if(remain==0) result++;
            return;
        }
        remain+=nums[i];
        backtrack(nums, i+1, remain);
        remain-=nums[i];

        remain-=nums[i];
        backtrack(nums, i+1, remain);
        remain+=nums[i];
    }

    //dp1
    public int findTargetSumWaysSample(int[] nums, int target) {
        if (nums.length == 0) return 0;
        return dp(nums, 0, target);
    }

    // 备忘录
    HashMap<String, Integer> memo = new HashMap<>();
    int dp(int[] nums, int i, int remain) {
        // base case
        if (i == nums.length) {
            if (remain == 0) return 1;
            return 0;
        }
        // 把它俩转成字符串才能作为哈希表的键
        String key = i + "," + remain;
        // 避免重复计算
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // 还是穷举
        int result = dp(nums, i + 1, remain - nums[i]) + dp(nums, i + 1, remain + nums[i]);
        // 记入备忘录
        memo.put(key, result);
        return result;
    }

    public int find(int[] nums, int target){
        int sum = 0;
        for(int i : nums){
            sum += i;
        }

        int[][] dp = new int[nums.length+1][sum*2+1];
        dp[0][sum] = 1;

        for(int i = 1; i<= nums.length; i++){
            for(int j = 0 ; j < sum*2+1 ; j++){
                if(dp[i-1][j] == 0){
                    continue;
                }
                dp[i][j-nums[i]] += dp[i-1][j];
                dp[i][j+nums[i]] += dp[i-1][j];
            }
        }

        return dp[nums.length-1][sum+target];
    }



}
