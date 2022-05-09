package basics;

public class ImplementStrStr {
    public static void main(String[] args) {
        String s = "mississippi";
        String t = "issip";

        Solution28 test = new Solution28();
        test.strStr(s,t);
    }
}

class Solution28 {
    public int strStr(String haystack, String needle) {
        if(needle==null || needle.length()==0) return 0;
        if(haystack.length()<needle.length()) return -1;

        for(int i=0; i<haystack.length()-needle.length(); i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                for(int j=1; j<needle.length(); j++){
                    if(haystack.charAt(i+j)!=needle.charAt(j)) {
                        break;
                    }
                }
                return i;
            }
        }

        return -1;
    }

    //KMP
    public int strStrSample(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int[] lps = computeKMPTable(needle);
        int i = 0, j = 0, n = haystack.length(), m = needle.length();
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++i; ++j;
                if (j == m) return i - m; // found solution
            } else {
                if (j != 0) j = lps[j - 1]; // try match with longest prefix suffix
                else i++; // don't match -> go to next character of `haystack` string
            }
        }
        return -1;
    }
    private int[] computeKMPTable(String pattern) {
        int i = 1, j = 0, n = pattern.length();
        int[] lps = new int[n];
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i++] = ++j;
            } else {
                if (j != 0) j = lps[j - 1]; // try match with longest prefix suffix
                else i++; // don't match -> go to next character
            }
        }
        return lps;
    }
}