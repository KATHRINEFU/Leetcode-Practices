package dp;

import java.util.*;

/**
 * @ClassName DeleteAndEarn
 * @Description TODO
 * @Author katefu
 * @Date 7/10/22 6:18 PM
 * @Version 1.0
 **/
public class DeleteAndEarn {
    public static void main(String[] args) {
        int[] nums = {2,2,3,3,3,4};
        Solution740 test = new Solution740();
        test.deleteAndEarnSample3(nums);
    }
}

class Solution740 {
    HashMap<Integer, List<Integer>> map;
    boolean[] isDeleted;
    public int deleteAndEarn(int[] nums) {
        map= new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(!map.containsKey(nums[i])){
                List<Integer> list= new ArrayList<>();
                map.put(nums[i], list);
            }
            map.get(nums[i]).add(i);
        }
        int m = map.size();
        int res = 0;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            isDeleted = new boolean[m];
            res = Math.max(res, dp(entry.getKey(), nums));
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue().size());
//            List<Integer> list = entry.getValue();
//            for(int i=0; i<list.size(); i++){
//                System.out.print(list.get(i));
//                System.out.print(" ");
//            }
//            System.out.println("-----------");
        }

        return res;
    }

    public int dp(int cur, int[] nums){
        if(isDeleted[cur]) return 0;
        List<Integer> index = map.get(cur);
        int res = cur*index.size();
        isDeleted[cur] = true;
        return res+dp(cur-1, nums)+dp(cur+1, nums);
    }

    public int deleteAndEarnSample(int[] nums) {
        int n = 10001;
        int[] values = new int[n];
        for (int num : nums)
            values[num] += num;

        int take = 0, skip = 0;
        for (int i = 0; i < n; i++) {
            int takei = skip + values[i];
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }
        return Math.max(take, skip);
    }

    //sums array to map each value (array's index) with the total sum you can earn by deleting all elements of that value (array's value)
    public int deleteAndEarnSample2(int[] nums) {
        int[] sum = new int[10002];

        for(int i = 0; i < nums.length; i++){
            sum[nums[i]] += nums[i];
        }

        for(int i = 2; i < sum.length; i++){
            sum[i] = Math.max(sum[i-1], sum[i-2] + sum[i]);
        }
        return sum[10001];
    }

    // top down DP solution
    public int deleteAndEarnSample3(int[] nums) {
        // if we sort the array, we do not need to delete elements smaller than nums[idx] (ie nums[idx] - 1) because they are already computed
        // and saved in memo, we only need to delete nums[idx] + 1 and we can do this simply by skipping them since the array is sorted
        Arrays.sort(nums);
        return deleteAndEarn(nums, 0, new int[nums.length]);
    }

    private int deleteAndEarn(int[] nums, int idx, int[] memo) {
        // if we reached the end of the array, we can not earn anymore, return 0
        if(idx == nums.length)
            return 0;

        if(memo[idx] == 0) {
            // delete and earn this element
            int earned = nums[idx];
            int skip = idx + 1;

            // simply add all similar values of nums[idx] to earned at once
            while(skip < nums.length && nums[skip] == nums[idx]) {
                earned += nums[idx];
                skip++;
            }

            // skip all elements = nums[idx] + 1
            // this is instead of deleting the elements = nums[idx] + 1
            // which does not alter the array and make the solution work
            while(skip < nums.length && nums[skip] == nums[idx] + 1)
                skip++;

            // recurse
            earned += deleteAndEarn(nums, skip, memo);

            // skip deleting and earning this element
            int skipped = deleteAndEarn(nums, idx + 1, memo);

            // return the max of the 2 values
            memo[idx] = Math.max(earned, skipped);
        }

        return memo[idx];
    }
}