package medium;

public class JumpGame {
}

/*
You are given an integer array nums.
You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.
 */
class Solution {

    //greedy
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;

        int maxLocation = 0;
        for(int i=0; i<nums.length; i++) {
            if(maxLocation<i) return false;
            maxLocation = (i+nums[i]) > maxLocation ? i+nums[i] : maxLocation; // greedy:
        }
        return true;
    }

    //DP
    public boolean canJumpSample(int[] nums) {
        if(nums.length < 2) return true;

        for(int curr = nums.length-2; curr>=0;curr--){
            if(nums[curr] == 0){
                int neededJumps = 1;
                while(neededJumps > nums[curr]){
                    neededJumps++;
                    curr--;
                    if(curr < 0) return false;
                }
            }
        }
        return true;
    }
}