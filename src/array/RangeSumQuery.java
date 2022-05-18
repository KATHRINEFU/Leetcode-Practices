package array;

/**
 * @ClassName RangeSumQuery
 * @Description Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * @Author katefu
 * @Date 5/15/22 6:25 PM
 * @Version 1.0
 **/
public class RangeSumQuery {
}

class Solution303 {
    private int[] preSum;

    /* 输入一个数组，构造前缀和 */
    public void NumArray(int[] nums) {
        // preSum[0] = 0，便于计算累加和
        preSum = new int[nums.length + 1];
        // 计算 nums 的累加和
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    /* 查询闭区间 [left, right] 的累加和 */
    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
