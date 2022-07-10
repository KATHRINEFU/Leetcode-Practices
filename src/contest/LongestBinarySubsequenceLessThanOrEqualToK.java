package contest;

import java.util.Arrays;

/**
 * @ClassName LongestBinarySubsequenceLessThanOrEqualToK
 * @Description You are given a binary string s and a positive integer k.
 *
 * Return the length of the longest subsequence of s that makes up a binary number less than or equal to k.
 * @Author katefu
 * @Date 7/4/22 11:29 AM
 * @Version 1.0
 **/
public class LongestBinarySubsequenceLessThanOrEqualToK {
}

class Solution5{
    public int longestSubsequence(String s, int k) {
        int val = 0, cnt = 0, pow = 1;
        for (int i = s.length() - 1; i >= 0 && val + pow <= k; --i) {
            if (s.charAt(i) == '1') {
                ++cnt;
                val += pow;
            }
            pow <<= 1;
        }
        return (int)s.chars().filter(ch -> ch == '0').count() + cnt;
    }

    //dp
    public int longestSubsequenceDP(String s, int k){
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int power = 0;
        long score = 0;
        return solve(s, n-1, power, score, k, dp);
    }

    public int solve(String s, int index, int power, long score, int k, int[] dp){
        if(index<0) return 0;
        if(dp[index]!=-1) return dp[index];
        int include = 0;
        if(s.charAt(index)=='1'){
            if(score+Math.pow(2, power)<=k){
                include+=1+solve(s, index-1, power+1, (long) (score+Math.pow(2, power)), k, dp);
            }
        }else{
            include+=1+solve(s, index-1, power+1, score, k, dp);
        }

        int notInclude = solve(s, index-1, power, score, k, dp);
        return dp[index]=Math.max(include, notInclude);
    }
}

