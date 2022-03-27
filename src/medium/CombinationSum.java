package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        Solution39 test = new Solution39();
        test.combinationSum(candidates,target);
    }
}

class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates, list, new ArrayList<>(), 0, 0,target);
        return list;
    }

    public void findSum(int[] nums, List<List<Integer>> res, List<Integer> temp, int tempSum, int start, int target){
        if(tempSum==target){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(tempSum>target){
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(tempSum+nums[i]>target) break;
            tempSum+=nums[i];
            temp.add(nums[i]);
            findSum(nums, res, temp, tempSum, i,target);
            tempSum-=nums[i];
            temp.remove(temp.size()-1);
        }
    }
}