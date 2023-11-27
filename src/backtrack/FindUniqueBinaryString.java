package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName FindUniqueBinaryString
 * @Description TODO
 * @Author katefu
 * @Date 11/16/23 3:39 PM
 * @Version 1.0
 **/
public class FindUniqueBinaryString {
    public static void main(String[] args) {
        String[] nums = {"01","10"};
        Solution1980 test = new Solution1980();
        test.findDifferentBinaryString(nums);
    }
}

class Solution1980 {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        Set<String> numsSet = new HashSet<>(List.of(nums));
        List<Character> inner = new ArrayList<>();
        return backtrack(numsSet, n, 0, inner);
    }

    public String backtrack(Set<String> numsSet, int n, int start, List<Character> inner){
        if(start == n){
            String cur = convertListToString(inner);
            if(!numsSet.contains(cur)){
                return cur;
            }else{
                return "";
            }
        }
        inner.add('0');
        String curWithZero = backtrack(numsSet, n, start+1, inner);
        inner.remove(inner.size()-1);

        inner.add('1');
        String curWithOne = backtrack(numsSet, n, start+1, inner);
        inner.remove(inner.size()-1);

        return curWithZero.equals("") ? curWithOne: curWithZero;
    }

    private String convertListToString(List<Character> list){
        StringBuilder sb = new StringBuilder();
        for(char c: list){
            sb.append(c);
        }
        return sb.toString();
    }

    public String findDifferentBinaryStringSample(String[] nums) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<nums.length;i++)
        {
            sb.append(nums[i].charAt(i) == '0'? "1": "0");
        }
        return new String(sb);
    }
}