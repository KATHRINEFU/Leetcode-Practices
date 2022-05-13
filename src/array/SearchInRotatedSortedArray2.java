package array;

/**
 * @ClassName SearchInRotatedSortedArray2
 * @Description
 *     There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 *     Before being passed to your function, nums is rotated at an unknown pivot index k.
 *     Given the array nums after the rotation and an integer target, return true if target is in nums,
 *     or false if it is not in nums.
 * @Author katefu
 * @Date 5/13/22 11:49 AM
 * @Version 1.0
 **/
public class SearchInRotatedSortedArray2 {
}

class Solution81{
    /*
1) everytime check if target == nums[mid], if so, we find it.
2) otherwise, we check if the first half is in order (i.e. nums[left]<=nums[mid])
  and if so, go to step 3), otherwise, the second half is in order,   go to step 4)
3) check if target in the range of [left, mid-1] (i.e. nums[left]<=target < nums[mid]),
  if so, do search in the first half, i.e. right = mid-1; otherwise, search in the second half left = mid+1;
4)  check if target in the range of [mid+1, right] (i.e. nums[mid]<target <= nums[right]),
  if so, do search in the second half, i.e. left = mid+1; otherwise search in the first half right = mid-1;
     */
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
                //any of the two sides won't change the result but can help remove duplicate from
                //consideration, here we just use end-- but left++ works too
            } else {
                end--;
            }
        }

        return false;
    }
}