package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Sum4
 * @Description
 *     Given an array nums of n integers, return an array of all the unique quadruplets
 *     [nums[a], nums[b], nums[c], nums[d]] such that:
 *     1) 0 <= a, b, c, d < n
 *     2) a, b, c, and d are distinct.
 *     3) nums[a] + nums[b] + nums[c] + nums[d] == target
 *     You may return the answer in any order.
 * @Author katefu
 * @Date 5/9/22 11:07 AM
 * @Version 1.0
 **/
public class Sum4 {
}

class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < nums.length; j++){
                if(j != i+1 && nums[j] == nums[j-1]) continue;
                int t = target - nums[i] - nums[j];
                int m = j+1, n = nums.length-1;
                while(m < n){
                    if(nums[m]+nums[n] == t){
                        Integer[] temp = {nums[i], nums[j], nums[m], nums[n]};
                        res.add(Arrays.asList(temp));
                        m++;
                        n--;
                        while(m < nums.length && nums[m] == nums[m-1]) m++;
                        while(n >= 0 && nums[n] == nums[n+1]) n--;
                    } else if(nums[m]+nums[n] < t){
                        m++;
                    } else n--;
                }
            }
        }
        return res;
    }

    // general & recursive version
    public List<List<Integer>> fourSumGeneral(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        kSum(result, new ArrayList<>(), nums, 0, target, 4);
        return result;
    }

    // General kSum solution. Assumes that k >= 2 and that nums is sorted.
    private void kSum(List<List<Integer>> result, List<Integer> tuple, int[] nums, int start, int target, int k) {
        // Not enough elements or
        // elements are guaranteed to sum up to > target (choose min element k times is already too much) or
        // elements are guaranteed to sum up to < target (even choosing the max element k times is too little).
        if (nums == null || start + k > nums.length || nums[start] * k > target || nums[nums.length - 1] * k < target) return;

        // Base case is 2sum.
        if (k == 2) {
            int l = start, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    assert (sum == target);
                    List<Integer> temp = new ArrayList<>(tuple);
                    temp.add(nums[l]); temp.add(nums[r]);
                    result.add(temp);

                    l++;
                    while (l < r && nums[l - 1] == nums[l]) l++;    // Skip duplicates.
                }
            }
        } else {
            for (int i = start; i < nums.length; ++i) {
                if (i > start && nums[i - 1] == nums[i]) continue;   // Skip duplicates.
                tuple.add(nums[i]);
                kSum(result, tuple, nums, i + 1, target - nums[i], k - 1);
                tuple.remove(tuple.size() - 1);  // Backtrack.
            }
        }
    }

}