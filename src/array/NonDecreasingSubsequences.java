package array;

import java.util.*;

/**
 * @ClassName NonDecreasingSubsequences
 * @Description TODO
 * @Author katefu
 * @Date 1/19/23 11:12 PM
 * @Version 1.0
 **/
public class NonDecreasingSubsequences {
    public static void main(String[] args) {
        int[] a = {4,6,7,7};
        Solution491 test = new Solution491();
        test.findSubsequences(a);
    }

}

class Solution491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length==0) return null;
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>(), 0);
        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> out, List<Integer> in, int start){
        if(in.size()>=2){
            out.add(new ArrayList<>(in));
        }
        Set<Integer> used = new HashSet<>();
        for(int i=start; i<nums.length; i++){
            if(!in.isEmpty() && in.get(in.size()-1)>nums[i]) continue;
            if(used.contains(nums[i])) continue;
            used.add(nums[i]);
            in.add(nums[i]);
            backtrack(nums, out, in, i+1);
            in.remove(in.size()-1);
        }
    }
}