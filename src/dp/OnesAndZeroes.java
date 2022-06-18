package dp;

/**
 * @ClassName OnesAndZeroes
 * @Description TODO
 * @Author katefu
 * @Date 6/16/22 11:10 AM
 * @Version 1.0
 **/
public class OnesAndZeroes {
    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        Solution474 test = new Solution474();
        test.findMaxForm(strs,3,3);
    }
}

class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) { // 遍历物品
            int oneNum = 0, zeroNum = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') zeroNum++;
                else oneNum++;
            }
            for (int i = m; i >= zeroNum; i--) { // 遍历背包容量且从后向前遍历！
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
