package array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @ClassName MininumOperationsToMakeArrayContinuous
 * @Description TODO
 * @Author katefu
 * @Date 10/10/23 8:26 PM
 * @Version 1.0
 **/
public class MininumOperationsToMakeArrayContinuous {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,6};
        Solution2009 test = new Solution2009();
        test.minOperationsSample(nums);
    }
}

class Solution2009 {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        // dp[i]: length of continuous array ending with dp[i];
        dp[0] = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]+1){
                dp[i] = dp[i-1]+1;
            }else{
                dp[i] = 1;
            }
        }

        int max = 0;
        for(int i=0; i<dp.length; i++){
            max = Math.max(max, dp[i]);
        }

        return nums.length - max;
    }

    public int minOperationsSample(int[] nums) {
        Arrays.sort(nums);

        int uniqueLen = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=nums[i-1]) nums[uniqueLen++] = nums[i];
        }

        // arr[0...uniqueLen]: valid arr

        int res = nums.length;
        for(int i=0,j=0; i<uniqueLen; i++){
            while(j<uniqueLen && nums[j] - nums[i]<= nums.length){
                j++;
            }
            res = Math.min(res, nums.length -(j-i));
        }

        return res;
    }

    // sliding window
    public int minOperationsSample2(int[] nums) {
        Arrays.sort(nums); // Sort the array

        int n = nums.length;
        int maxNumsInWindow = 0;

        Deque<Integer> numsInWindow = new ArrayDeque<>();
        for (int num : nums) {
            // Advance the window
            while (numsInWindow.size() > 0 && num - numsInWindow.peekFirst() >= n) {
                numsInWindow.poll();
            }

            // Add the new number to the window (if it's not a duplicate)
            if(numsInWindow.size() == 0 || ! numsInWindow.peekLast().equals(num)) {
                numsInWindow.offer(num);
            }

            maxNumsInWindow = Math.max(maxNumsInWindow, numsInWindow.size());
        }

        return n - maxNumsInWindow;
    }
}