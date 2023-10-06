package array;

/**
 * @ClassName SearchInRotatedSortedArray
 * @Description TODO
 * @Author katefu
 * @Date 6/28/23 9:58 AM
 * @Version 1.0
 **/
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        Solution33 test = new Solution33();
        test.search(nums,2);
    }
}

class Solution33 {
    public int search(int[] nums, int target) {
        int minIndex = findMinIndex(nums);

        int left = 0;
        int right = nums.length-1;
        int mid=Integer.MAX_VALUE;

        while(left<=right){
            mid = left+(right-left)/2;
            int realMid = (mid+minIndex)%nums.length;
            if(nums[realMid]==target) return realMid;
            else if(nums[realMid]<target) left = mid+1;
            else right = mid-1;
        }
        return -1;


    }

    public int findMinIndex(int[] nums){
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left + (right - left)/2;
            if(nums[mid]> nums[right]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
