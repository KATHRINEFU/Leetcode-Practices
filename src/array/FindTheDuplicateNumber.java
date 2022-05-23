package array;

/**
 * @ClassName FindTheDuplicateNumber
 * @Description
 *     Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * @Author katefu
 * @Date 5/23/22 12:32 PM
 * @Version 1.0
 **/
public class FindTheDuplicateNumber {
}

class Solution287{

    //双指针，环形链表
    public int findDuplicate_fastSlow(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    //二分查找
    /*
    So guess a number first(the number mid in the valid range [left, right]),
    count the elements of the array which is less than or equal to mid in the array.

    If cnt is strictly greater than mid. According to the Pigeonhole Principle,
    repeated elements are in the interval [left, mid];
    Otherwise, the repeated element is in the interval [mid + 1, right].
     */
    public static int findDuplicate_bs(int[] nums) {
        int len = nums.length;
        int low = 1;
        int high = len - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }

            if (cnt <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

}
