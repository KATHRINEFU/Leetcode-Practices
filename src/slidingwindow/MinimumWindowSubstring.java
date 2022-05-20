package slidingwindow;

import java.util.HashMap;

/**
 * @ClassName MinimumWindowSubstring
 * @Description
 *     Given two strings s and t of lengths m and n respectively,
 *     return the minimum window substring of s such that every character in t
 *     (including duplicates) is included in the window.
 *     If there is no such substring, return the empty string "".
 * @Author katefu
 * @Date 5/19/22 4:10 PM
 * @Version 1.0
 **/
public class MinimumWindowSubstring {
}

class Solution76 {
    public String minWindow(String s, String t) {
        if ( t.length() > s.length() ) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(int i=0; i<t.length(); i++){
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left=0, right=0, valid=0;
        int len = Integer.MAX_VALUE;
        int start=0;

        while(right<s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while(valid == need.size()){
                if(right-left<len){
                    start = left;
                    len = right-left;
                }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }

        return len==Integer.MAX_VALUE?"":s.substring(start, start+len);
    }
}
