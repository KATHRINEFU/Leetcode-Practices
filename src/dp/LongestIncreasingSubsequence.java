package dp;

/**
 * @ClassName LongestIncreasingSubsequence
 * @Description Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * @Author katefu
 * @Date 6/6/22 10:41 AM
 * @Version 1.0
 **/
public class LongestIncreasingSubsequence {
}

class Solution300 {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0]=1;
        for(int i=1; i<nums.length; i++){
            int temp=0;
            for(int j=i-1; j>=0; j--){
                if(nums[j]<nums[i]){
                    temp = Math.max(temp, dp[j]);
                }
            }
            dp[i] = temp+1;
        }

        int max=0;
        for(int i=0; i<dp.length; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //二分法，类似扑克
    int lengthOfLISSample(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为 0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            /***** 搜索左侧边界的二分查找 *****/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            /*********************************/

            // 没找到合适的牌堆，新建一堆
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }
}
