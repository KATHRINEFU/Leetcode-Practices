package dp;

/**
 * @ClassName RegularExpressionMatching
 * @Description
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * @Author katefu
 * @Date 6/20/22 11:55 AM
 * @Version 1.0
 **/
public class RegularExpressionMatching {

}

class Solution10{
    //bottom up
    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        //what pattern matches empty string ""? It should be #*#*#*#*...
        //even positions are *
        for (int i = 2; i <= p.length(); i+=2) {
            if (p.charAt(i-1) == '*' && dp[0][i-2]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    //if not j-1 not match, * should represent 0
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        //dp[i+1][j]:1个*匹配
                        //dp[i][j+1]:多个*匹配
                        //dp[i+1][j-1]：0个
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    //top down
    public boolean isMatchSample(String s, String p) {
        return dp(s,0,p,0);
    }

    public boolean dp(String s, int i, String p, int j){
        int m = s.length(), n = p.length();
        if(i==m){
            if((n-j)%2==1) return false;
            for(; j+1<n;j+=2){
                if(p.charAt(j+1)!='*') return false;
            }
            return true;
        }
        if(j==n){
            return i==m;
        }

        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){
            //match
            if(j<n-1 && p.charAt(j+1)=='*')
                return dp(s,i,p,j+2) || dp(s,i+1,p,j);
            else return dp(s,i+1,p,j+1);
        }
        else{
            //not match
            if(j<n-1 && p.charAt(j+1)=='*'){
                return dp(s,i,p,j+2);
            }
            else return false;
        }
    }
}

