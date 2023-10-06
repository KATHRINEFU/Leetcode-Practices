package OA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Meituan
 * @Description TODO
 * @Author katefu
 * @Date 11/4/22 11:04 PM
 * @Version 1.0
 **/
public class Meituan {
    public static void main(String[] args) {
        String s = "abaabbccdca";
        int res = minimumDeletions(s);
        System.out.println(res);
    }

    public static int minimumDeletions(String s) {
        int l = s.length();
        //dp stores number of chars to remove to make s.substring(0, i) valid
        int[] dp = new int[l + 1];//dp[i]=k: min deletions is k for first i elements
        int count = 0;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 2; i < l; i++) {
            if(s.charAt(i)==s.charAt((i-1)) && s.charAt(i)==s.charAt(i-2)){
                dp[i+1] = dp[i-2];
            }else if(s.charAt(i)==s.charAt(i-1) && s.charAt(i)!=s.charAt(i-2)){
                dp[i+1] = dp[i-1]+2;
            }else if(s.charAt(i)!=s.charAt(i-1)){
                dp[i+1] = dp[i]+1;
            }
        }

        return dp[l];
    }
}
