package greedy;

import java.util.HashMap;

/**
 * @ClassName LongestPalindromeByConcatenatingTwoLetterWords
 * @Description
 * You are given an array of strings words. Each element of words consists of two lowercase English letters.
 *
 * Create the longest possible palindrome by selecting some elements from words and concatenating them in any order.
 * Each element can be selected at most once.
 *
 * Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
 * @Author katefu
 * @Date 7/13/22 12:16 PM
 * @Version 1.0
 **/
public class LongestPalindromeByConcatenatingTwoLetterWords {
}

class Solution2131 {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> m = new HashMap();
        int unpaired = 0, ans = 0;
        for (String w: words) {
            if (!m.containsKey(w)) m.put(w, 0);
            if (w.charAt(0) == w.charAt(1)) {
                if (m.get(w) > 0) {
                    unpaired--;
                    m.put(w, m.get(w) - 1);
                    ans += 4;
                }
                else {
                    m.put(w, m.get(w) + 1);
                    unpaired++;
                }
            }
            else {
                String rev = Character.toString(w.charAt(1)) +
                        Character.toString(w.charAt(0));
                if (m.containsKey(rev) && m.get(rev) > 0) {
                    ans += 4;
                    m.put(rev, m.get(rev) - 1);
                }
                else m.put(w, m.get(w) + 1);
            }

        }
        if (unpaired > 0) ans += 2;
        return ans;
    }
}
