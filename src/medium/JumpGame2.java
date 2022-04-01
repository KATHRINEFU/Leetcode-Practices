package medium;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Solution45 test = new Solution45();
        test.jumpSample2(nums);
    }
}

class Solution45 {

    //time limit exceed
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        return findMinStep(nums, 0, 0, nums.length);
    }

    public int findMinStep(int[] nums, int step,int i, int minStep){
        if(i>=nums.length-1) return step;
        step++;
        for(int j=1; j<=nums[i]; j++){
            int tempStep = findMinStep(nums, step, i+j, minStep);
            if(tempStep<minStep) minStep = tempStep;
        }
        return minStep;
    }

    //greedy
    public int jumpSample(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    //dp
    public int jumpSample2(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++){
            dp[i] = 0;
        }
        solve(nums, 0, dp);
        return dp[0];
    }

    private int solve(int[] nums, int index,int[] dp){
        if(index >= nums.length-1)
            return 0;
        if(dp[index] > 0)
            return dp[index];
        int res = nums.length+1;
        for(int i = 1; i <= nums[index] && i+index <= nums.length; i++){
            int steps = 1+solve(nums,index+i,dp);
            res = Math.min(res,steps);
        }
        dp[index] = res;
        return res;
    }
}