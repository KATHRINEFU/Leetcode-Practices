package dp;

/**
 * @ClassName MinimumASCIIDeleteSumForTwoStrings
 * @Description TODO
 * @Author katefu
 * @Date 6/8/22 7:02 PM
 * @Version 1.0
 **/
public class MinimumASCIIDeleteSumForTwoStrings {
    public static void main(String[] args) {
        String s = "abs";
        Solution712 test = new Solution712();
        System.out.println(test.ascii(s));

    }
}

class Solution712 {
//    public int minimumDeleteSum(String s1, String s2) {
//        int len1 = s1.length(), len2 = s2.length();
//        if (len1 == 0) return ascii(s2);
//        if (len2 == 0) return ascii(s1);
//
//        int[][] dp = new int[len1 + 1][len2 + 1];
//        for (int i = 0; i <= len1; i++)
//            dp[i][0] = ascii(s1.substring(0,i+1))；
//        for (int j = 0; j <= len2; j++)
//            dp[0][j] = ascii(s2.substring(0, j+1));
//
//        for (int i = 1; i <= len1; i++) {
//            for (int j = 1; j <= len2; j++) {
//                if (s1.charAt(i - 1) == s2.charAt(j - 1))
//                    dp[i][j] = dp[i - 1][j - 1];
//                else{
//                    dp[i][j] = Math.min(dp[i - 1][j] + charAt(i)), dp[i][j - 1] + charAt(j));
//                }
//
//            }
//        }
//
//        return dp[len1][len2];
//    }

    public int ascii(String s){
        int res=0;
        for(int i=0; i<s.length(); i++){
            res+=s.charAt(i);
        }
        return res;
    }


    public int minimumDeleteSumSample(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    int a = 0;
                    for(int z=1;z<=Math.max(j,i);z++){
                        a += (i==0?s2.charAt(z-1):s1.charAt(z-1));
                    }
                    dp[i][j] = a;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(s1.charAt(i-1)+dp[i-1][j],s2.charAt(j-1)+dp[i][j-1]);
                    dp[i][j] = Math.min(dp[i][j],s1.charAt(i-1)+s2.charAt(j-1)+dp[i-1][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
