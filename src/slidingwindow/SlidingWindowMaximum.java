package slidingwindow;

import java.util.*;

/**
 * @ClassName SlidingWindowMaximum
 * @Description TODO
 * @Author katefu
 * @Date 1/14/24 8:33 PM
 * @Version 1.0
 **/
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution239 test = new Solution239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = test.maxSlidingWindow(nums, 3);
        for(int i: res){
            System.out.println(i);
        }
    }
}

class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peekFirst() < i - k + 1) q.pollFirst(); // shrink window
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) q.pollLast(); // keep decreasing
            q.offer(i); // expand window
            if (i >= k - 1) ans[j++] = nums[q.peekFirst()]; // current peek
        }
        return ans;
    }
}
