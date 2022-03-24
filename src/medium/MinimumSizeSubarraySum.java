package medium;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        Solution209 test = new Solution209();
        int res = test.minSubArrayLenSample(target, nums);
        System.out.println(res);
    }
}

class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int res=0;
        int left=0;
        int sum=0;

        //initial window
        int len=0;
        sum +=nums[len];
        while(sum<target){
            len++;
            sum+=nums[len];
        }
        res = len-left+1;

        int start=0;
        int right = res-1;
        while(right<nums.length){
            if(right+1<nums.length) sum+=nums[++right];
            while(sum-nums[start]>=target){
                sum-=nums[start];
                start++;
            }
            res = Math.min(res, right-start+1);
            if(right==nums.length-1) break;
        }

        return res;

    }

    public int minSubArrayLenSample(int s, int[] nums) {
        int sum = 0, from = 0, win = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                win = Math.min(win, i - from + 1);
                sum -= nums[from++];
            }
        }
        return (win == Integer.MAX_VALUE) ? 0 : win;
    }

}