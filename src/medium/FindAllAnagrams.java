package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p="abc";
        Solution438 test = new Solution438();
        test.findAnagrams(s,p);
    }
}

class Solution438 {
    // time limited exceed
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length()<p.length()) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        for(int j=0; j<p.length(); j++){
            if(pMap.containsKey(p.charAt(j))){
                pMap.put(p.charAt(j), pMap.get(p.charAt(j)+1));
            }else{
                pMap.put(p.charAt(j),1);
            }
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<i+p.length(); j++){
                if(j>s.length()-1) break;
                if(map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j), map.get(s.charAt(j)+1));
                }else{
                    map.put(s.charAt(j),1);
                }
            }
            if(map.equals(pMap)) list.add(i);
            map.clear();
        }

        return list;
    }

    //sliding window
    public List<Integer> findAnagramsSample(String s, String p) {
        if(s.length()<p.length()) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        int[] countP = new int[26];
        // count freq in p
        for(int i=0; i<p.length(); i++){
            countP[p.charAt(i)-'a']++;
        }

        //initial window for s
        int[] countS = new int[26];
        for(int i=0; i<p.length(); i++){
            countS[s.charAt(i)-'a']++;
        }

        if(sameCount(countP, countS)) list.add(0);

        //sliding window
        for(int j=m; j<n; j++){
            countS[s.charAt(j-m)-'a']--;
            countS[s.charAt(j)-'a']++;
            if(sameCount(countP, countS)) list.add(j-m+1);
        }

        return  list;
    }

    private boolean sameCount(int[] p, int[] s){
        for(int i=0; i<26; i++){
            if(p[i]!=s[i]) return false;
        }
        return true;
    }
}
