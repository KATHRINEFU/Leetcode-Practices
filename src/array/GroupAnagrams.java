package array;

import java.util.*;

/**
 * @ClassName GroupAnagrams
 * @Description TODO
 * @Author katefu
 * @Date 6/15/23 10:32 PM
 * @Version 1.0
 **/
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs =  {"eat","tea","tan","ate","nat","bat"};
        Solution49 test = new Solution49();
        test.groupAnagrams(strs);
    }
}

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> mapMap = new HashMap<>();
        List<List<String>> resList = new ArrayList<>();
        for(String str: strs){
            Map<Character, Integer> map = new TreeMap<>();
            for(char c: str.toCharArray()){
                map.put(c, map.getOrDefault(c, 0)+1);
            }
            if(mapMap.containsKey(map)) {
                mapMap.get(map).add(str);
            }
            else{
                mapMap.put(map, new ArrayList<String>());
                mapMap.get(map).add(str);
            }
        }

        resList.addAll(mapMap.values());
        return resList;
    }

    public List<List<String>> groupAnagramsSample(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] hash = new int[26];
            for (char c : s.toCharArray()) {
                hash[c - 'a']++;
            }
            String key = new String(Arrays.toString(hash));
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(s);
        }
        res.addAll(map.values());
        return res;
    }
}