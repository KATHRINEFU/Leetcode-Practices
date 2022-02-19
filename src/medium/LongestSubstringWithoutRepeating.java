package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Kate Fu
 * @create: 2022-02-13 8:58
 */
public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String s = "ashbbjkc";
        Solution3 test = new Solution3();
        test.lengthOfLongestSubstringSample2(s);
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        for(int i=s.length(); i>0; i--){
            for(int j=0; j<=s.length()-i; j++){
                if(!checkDuplicate(s, j, j+i-1)){
                    return i;
                }
            }
        }
        return 1;
    }

    public boolean checkDuplicate(String s, int j, int i){
        HashSet<Character> set = new HashSet<>();
        for(int a=j; a<=i; a++){
            if(!set.add(s.charAt(a))){
                return true;
            }
        }
        return false;
    }

    public int lengthOfLongestSubstringSample(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public int lengthOfLongestSubstringSample2(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}