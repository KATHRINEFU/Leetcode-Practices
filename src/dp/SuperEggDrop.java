package dp;

import java.util.Arrays;

/**
 * @ClassName SuperEggDrop
 * @Description
 * You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.
 *
 * You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break,
 * and any egg dropped at or below floor f will not break.
 *
 * Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n).
 * If the egg breaks, you can no longer use it. However, if the egg does not break, you may reuse it in future moves.
 *
 * Return the minimum number of moves that you need to determine with certainty what the value of f is.
 * @Author katefu
 * @Date 6/21/22 11:38 AM
 * @Version 1.0
 **/
public class SuperEggDrop {
}

class Solution887 {
    //dp+memo
    int[][] memo;
    public int superEggDrop(int k, int n) {
        memo = new int[n+1][k+1];
        for(int[] row: memo) Arrays.fill(row, -1);
        return dp(n,k);
    }

    public int dp(int n, int k){
        if(k==1) return n;
        if(n==0) return 0;
        if(memo[n][k]!=-1) return memo[n][k];
        int res = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            res = Math.min(res, Math.max(dp(i-1,k-1), dp(n-i, k))+1);
        }
        memo[n][k] = res;
        return memo[n][k];
    }

    public int dpBinarySearch(int n, int k){
        if(k==1) return n;
        if(n==1) return 1;
        if(memo[n][k]!=-1) return memo[n][k];

        int res = n;
        int right = 1;
        int left = n+1;
        while(left<right){
            int mid = (right-left)/2+left;
            int leftRes = dpBinarySearch(mid-1, k-1);
            int rightRes = dpBinarySearch(n-mid, k); //why k does not change to k-1
            res = Math.min(res, Math.max(leftRes, rightRes)+1);
            if(leftRes<rightRes) left = mid+1;
            else if(leftRes>rightRes) right = mid;
            else break;
        }
        memo[n][k] = res;
        return  memo[n][k];
    }

    private int dp2(int i , int j) {
        if (i == 1) return j;
        if (j == 1) return 1;
        if (memo[i][j] != 0) return memo[i][j];

        int result = j;
        int left = 1;
        int right = j + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int left_result = dp2(i - 1, mid - 1);//递增函数  关于mid的函数， 当mid 增加 楼层增加，尝试次数增加
            int right_result = dp2(i, j - mid);//递减函数
            result = Math.min(Math.max(left_result, right_result) + 1, result);
            if (left_result < right_result) {
                left = mid + 1;
            } else if (left_result > right_result) {
                right = mid;
            } else {
                break;
            }
        }
        memo[i][j] = result;
        return memo[i][j];
    }

    //lee215's
    /*
    dp[M][K]means that, given K eggs and M moves,
    what is the maximum number of floor that we can check.

    The dp equation is:
    dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1,
    which means we take 1 move to a floor,
    if egg breaks, then we can check dp[m - 1][k - 1] floors.
    if egg doesn't break, then we can check dp[m - 1][k] floors.
     */
    public int superEggDropSample(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        int m = 0;
        while (dp[m][K] < N) {
            ++m;
            for (int k = 1; k <= K; ++k)
                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
        }
        return m;
    }
}
