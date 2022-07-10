package contest;

/**
 * @ClassName SellingPiecesOfWood
 * @Description
 * You are given two integers m and n that represent the height and width of a rectangular piece of wood.
 * You are also given a 2D integer array prices, where prices[i] = [hi, wi, pricei] indicates you can sell a rectangular
 * piece of wood of height hi and width wi for pricei dollars.
 *
 * To cut a piece of wood, you must make a vertical or horizontal cut across the entire height or width of the piece
 * to split it into two smaller pieces. After cutting a piece of wood into some number of smaller pieces,
 * you can sell pieces according to prices. You may sell multiple pieces of the same shape, and you do not have to sell all the shapes.
 * The grain of the wood makes a difference, so you cannot rotate a piece to swap its height and width.
 *
 * Return the maximum money you can earn after cutting an m x n piece of wood.
 *
 * Note that you can cut the piece of wood as many times as you want.
 * @Author katefu
 * @Date 7/5/22 12:06 PM
 * @Version 1.0
 **/
public class SellingPiecesOfWood {
}

class Solution6{
    /*
    Explanation
For a piece of w * h,

we can make a vertical cut to split it into a * h and (w - a) * h
So we can update dp[w][h] = max(dp[w][h], dp[a][h] + dp[w - a][h]).

we can make a horizontal cut to split it into w * a and w * (h - a)
So we can update dp[w][h] = max(dp[w][h], dp[w][a] + dp[w][h - a]).


Complexity
Time O(mmn + mnn)
Space O(mn)
     */

    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m + 1][n + 1];
        for (int[] p : prices)
            dp[p[0]][p[1]] = p[2];
        for (int w = 1; w <= m; ++w) {
            for (int h = 1; h <= n; ++h) {
                for (int a = 1; a <= w / 2; ++a)
                    dp[w][h] = Math.max(dp[w][h], dp[a][h] + dp[w - a][h]);
                for (int a = 1; a <= h / 2; ++a)
                    dp[w][h] = Math.max(dp[w][h], dp[w][a] + dp[w][h - a]);
            }
        }
        return dp[m][n];
    }
}