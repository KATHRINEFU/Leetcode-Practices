package slidingwindow;

/**
 * @ClassName LongestRepeatingCharacterReplacement
 * @Description TODO
 * @Author katefu
 * @Date 10/8/23 11:33 AM
 * @Version 1.0
 **/
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        Solution424 test = new Solution424();
        test.characterReplacement(s, 1);
    }
}

class Solution424 {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int mostFreqLetter = 0;
        int left = 0;
        int max = 0;

        for(int right = 0; right<s.length(); right++){
            freq[s.charAt(right)-'A']++;
            mostFreqLetter = Math.max(mostFreqLetter, freq[s.charAt(right) - 'A']);
            int letterToReplace = (right-left+1) - mostFreqLetter;
            if(letterToReplace>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }

            max = Math.max(max, right-left+1);
        }

        return max;
    }
}
