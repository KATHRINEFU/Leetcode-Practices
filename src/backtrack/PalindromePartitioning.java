package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PalindromePartitioning
 * @Description TODO
 * @Author katefu
 * @Date 1/20/24 5:46 PM
 * @Version 1.0
 **/
public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "efe";
        Solution131 test = new Solution131();
        test.partition(s);
    }
}

class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(String s, int start, List<String> list, List<List<String>> res){
        if(start == s.length()){
            res.add(new ArrayList<>(list));
        }

        for(int i=start; i<s.length(); i++){
            String cur = s.substring(start, i+1);
            if(!isPalindrome(cur)) continue;
            list.add(cur);
            backtrack(s, i+1, list, res);
            list.remove(list.size()-1);
        }
    }

    public boolean isPalindrome(String s){
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
}
