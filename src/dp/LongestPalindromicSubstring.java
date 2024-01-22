package dp;

/**
 * @ClassName LongestPalindromicSubstring
 * @Description TODO
 * @Author katefu
 * @Date 1/20/24 6:27 PM
 * @Version 1.0
 **/
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        Solution5 test = new Solution5();
        test.longestPalindrome(s);
    }
}

class Solution5 {

    public String longestPalindrome(String s) {
        int len = s.length();
        int left = 0, right = 1, max = 0;

        var isPalindrome = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    isPalindrome[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        isPalindrome[i][j] = true;
                    } else {
                        isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                    }
                }

                if (isPalindrome[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    left = i;
                    right = j + 1;
                }
            }
        }

        return s.substring(left, right);
    }
}