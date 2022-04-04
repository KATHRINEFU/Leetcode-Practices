package medium;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "1123";
        Solution91 test = new Solution91();
        test.numDecodings(s);
    }
}

class Solution91 {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int[] memo = new int[s.length()];
        memo[0] =1;
        for(int i=1; i<s.length(); i++){
            if(Integer.parseInt(s.substring(i-1,i+1))<=26){
                memo[i] = memo[i-1]+1;
            }

            if(i==s.length()-1 && s.charAt(i)=='0'){
                memo[i]--;
            }
        }
        return memo[s.length()-1];
    }

    public int numDecodingsSample(String s) {
        if(s==null || s.length()==0) return 0;
        int[] memo = new int[s.length()+1];
        memo[0] =1;
        memo[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= s.length(); i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                memo[i] += memo[i-1];
            }
            if (second >= 10 && second <= 26) {
                memo[i] += memo[i-2];
            }
        }
        return memo[s.length()];
    }
}