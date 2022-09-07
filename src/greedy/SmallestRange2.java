package greedy;

import java.util.Arrays;

/**
 * @ClassName SmallestRange2
 * @Description You are given an integer array nums and an integer k.
 *
 * For each index i where 0 <= i < nums.length, change nums[i] to be either nums[i] + k or nums[i] - k.
 *
 * The score of nums is the difference between the maximum and minimum elements in nums.
 *
 * Return the minimum score of nums after changing the values at each index.
 * @Author katefu
 * @Date 8/27/22 5:04 PM
 * @Version 1.0
 **/
public class SmallestRange2 {
}

class Solution910 {
    int res = Integer.MAX_VALUE;
    int curMin = Integer.MAX_VALUE;
    int curMax = Integer.MIN_VALUE;
    int[] dirs;

    //time limit exceed
    public int smallestRangeII(int[] nums, int k) {
        dirs = new int[]{k, -k};
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int start){
        if(start==nums.length){
            res = Math.min(res, curMax-curMin);
            return;
        }

        for(int i=0; i<dirs.length; i++){
            nums[start]+=dirs[i];
            int tmpMax = curMax;
            int tmpMin = curMin;
            if(nums[start]>curMax) curMax = nums[start];
            if(nums[start]<curMin) curMin = nums[start];

            backtrack(nums, start+1);
            nums[start]-=dirs[i];
            curMax = tmpMax;
            curMin = tmpMin;
        }
    }

    public int smallestRangeIISample(int[] nums, int k) {
        Arrays.sort(nums); //sort the array
        int n=nums.length; //length of the array

        // If k>=nums[n-1]-nums[0] the score will always increase if we add k to some
        // numbers and subtract k from some numbers
        // Hence, the minimum score is the current score

        if (k >= nums[n-1]-nums[0]) {
            return nums[n-1]-nums[0];
        }

        // Now k < nums[n-1]-nums[0]
        // Add k to first p numbers and subtract k from remaining numbers
        // LEFT SEGMENT: First p numbers where we add k
        // RIGHT SEGMENT: Remaining numbers where we subtract k

        // LEFT SEGMENT: (nums[0]+k,nums[1]+k,......,nums[p-1]+k)
        // RIGHT SEGMENT: (nums[p]-k,nums[p+1]-k,.......nums[n-1]-k)

        // Question: Where is p?
        // Answer: We try all possible values for p and min score everytime

        // After subtracting and adding k to numbers,
        // the new minimum and maximum will be
        // minimum = min (nums[0]+k , nums[p]-k)
        // maximum = max (nums[p-1]+k, nums[n-1]-k)

        int minScore = nums[n-1]-nums[0];
        for (int p=1;p<n;p++) {
            int min = Math.min(nums[0]+k,nums[p]-k);
            int max = Math.max(nums[p-1]+k,nums[n-1]-k);
            minScore = Math.min(minScore,max-min);
        }

        return minScore;
    }
}
