package array;

import java.util.HashMap;

/**
 * @ClassName SubarraySumEqualsK
 * @Description TODO
 * @Author katefu
 * @Date 7/17/22 11:44 AM
 * @Version 1.0
 **/
public class SubarraySumEqualsK {
}

class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        //int[] preSum  = new int[n+1];
        HashMap<Integer, Integer> preSumCount = new HashMap<>(); //preSum -> preSumCount
        preSumCount.put(0, 1);
        // for(int i=1; i<=n; i++){
        //     preSum[i] = preSum[i-1]+nums[i];
        // }
        int res = 0, sum_i = 0;
        for(int i=0; i<n; i++){
            sum_i+=nums[i];
            int sum_j = sum_i-k;
            if(preSumCount.containsKey(sum_j)){
                res+=preSumCount.get(sum_j);
            }
            preSumCount.put(sum_i, preSumCount.getOrDefault(sum_i, 0)+1);
        }

        return res;
    }
}
