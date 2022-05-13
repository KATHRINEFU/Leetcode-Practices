package array;

/**
 * @ClassName RemoveDuplicatesFromSortedArray2
 * @Description
 *     Given an integer array nums sorted in non-decreasing order,
 *     remove some duplicates in-place such that each unique element appears at most twice.
 * @Author katefu
 * @Date 5/13/22 10:18 AM
 * @Version 1.0
 **/
public class RemoveDuplicatesFromSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        Solution80 test = new Solution80();
        test.removeDuplicates(nums);
    }
}

class Solution80 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }

    public int removeDuplicates(int A[], int n, int k) {

        if (n <= k) return n;

        int i = 1, j = 1;
        int cnt = 1;
        while (j < n) {
            if (A[j] != A[j-1]) {
                cnt = 1;
                A[i++] = A[j];
            }
            else {
                if (cnt < k) {
                    A[i++] = A[j];
                    cnt++;
                }
            }
            ++j;
        }
        return i;
    }
}