package medium;

/**
 * @author: Kate Fu
 * @create: 2022-02-18 18:20
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Solution198 test = new Solution198();
        int res = test.rob(nums);
        System.out.println(res);
    }
}

class Solution198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        if(nums.length==1) return nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }

        return dp[nums.length-1];
    }

    public static int robSample(int[] nums)
    {
        int ifRobbedPrevious = 0; 	// max monney can get if rob current house
        int ifDidntRobPrevious = 0; // max money can get if not rob current house

        // We go through all the values, we maintain two counts, 1) if we rob this cell, 2) if we didn't rob this cell
        for(int i=0; i < nums.length; i++)
        {
            // If we rob current cell, previous cell shouldn't be robbed. So, add the current value to previous one.
            int currRobbed = ifDidntRobPrevious + nums[i];

            // If we don't rob current cell, then the count should be max of the previous cell robbed and not robbed
            int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious);

            // Update values for the next round
            ifDidntRobPrevious  = currNotRobbed;
            ifRobbedPrevious = currRobbed;
        }

        return Math.max(ifRobbedPrevious, ifDidntRobPrevious);
    }
}