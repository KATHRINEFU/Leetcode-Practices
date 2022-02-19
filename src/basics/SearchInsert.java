package basics;

/**
 * @author: Kate Fu
 * @create: 2021-12-28 16:19
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target=7;
        Solution8 test = new Solution8();
        int res = test.searchInsert(nums, target);
        System.out.println(res);
    }
}

class Solution8 {
    public int searchInsert(int[] nums, int target) {
        if(target>nums[nums.length-1]) return nums.length;
        int res = biSearch(nums, 0, nums.length, target);
        return res;
    }

    public static int biSearch(int[] arr, int left, int right, int finalVal){
        if(left>right){
            return left;
        }
        int mid = (left+right)/2;
        int midVar = arr[mid];
        if(finalVal>midVar){
            return biSearch(arr,mid+1,right, finalVal);
        }else if(finalVal<midVar){
            return biSearch(arr, left, mid-1, finalVal);
        }else{
            return mid;
        }
    }

    public int searchInsertSample(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}