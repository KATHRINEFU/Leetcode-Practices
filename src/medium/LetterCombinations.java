package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {
    public static void main(String[] args) {
        String s = "23";
        Solution17 test = new Solution17();
        test.letterCombinationsSample(s);
    }
}

class Solution17 {

    private static String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0) return res;
        findCombination(digits, res, "", 0,mapping);
        return res;
    }

    //recursion
    public void findCombination(String digits, List<String> res, String prefix, int start, String[] mapping){
        if(start>=digits.length()){
            res.add(prefix);
            return;
        }

        String letters = mapping[(digits.charAt(start)-'0')];
        for(int i=0; i<letters.length(); i++){
            findCombination(digits, res, prefix+letters.charAt(i), start+1, mapping);
        }
    }

    //iterative, FIFO queue
    public List<String> letterCombinationsSample(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
}
