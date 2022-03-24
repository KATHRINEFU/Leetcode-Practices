package medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution78 test = new Solution78();
        test.subsets(nums);
    }
}

class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        findSubsets(nums, 0,list, new ArrayList<>());
        return list;
    }

    public void findSubsets(int[] nums, int i, List<List<Integer>> list, List<Integer> in){
        list.add(new ArrayList<>(in));

        for(int j=i; j<nums.length; j++){
            in.add(nums[j]);
            findSubsets(nums, j+1, list, in);
            in.remove(in.size()-1);
        }
    }

    /*
    DP Solution
    While iterating through all numbers, for each new number, we can either pick it or not pick it
    1, if pick, just add current number to every existing subset.
    2, if not pick, just leave all existing subsets as they are.
    We just combine both into our result.

    For example, {1,2,3} intially we have an emtpy set as result [ [ ] ]
    Considering 1, if not use it, still [ ], if use 1, add it to [ ], so we have [1] now
    Combine them, now we have [ [ ], [1] ] as all possible subset

    Next considering 2, if not use it, we still have [ [ ], [1] ], if use 2, just add 2 to each previous subset, we have [2], [1,2]
    Combine them, now we have [ [ ], [1], [2], [1,2] ]
     */
    public List<List<Integer>> subsetsSample(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
}