package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CombinationSum
 * @Description TODO
 * @Author katefu
 * @Date 5/9/24 10:38 PM
 * @Version 1.0
 **/
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        Solution39 test = new Solution39();
        test.combinationSum(candidates, target);
    }
}


class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, candidates, target, 0, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int curIndex, int curNum){
        if(curNum==target){
            res.add(new ArrayList<>(list));
            return;
        }

        if(curIndex==candidates.length){
            return;
        }

        curNum += candidates[curIndex];
        if(curNum>target) return;
        for(int i=0; i<candidates.length; i++){
            backtrack(res, list, candidates, target, i, curNum);
        }
        curNum -= candidates[curIndex];
    }
}