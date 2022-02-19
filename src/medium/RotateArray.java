package medium;

/**
 * @author: Kate Fu
 * @create: 2022-02-08 19:21
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k=3;
        Solution189 test = new Solution189();
        test.rotateSample(nums, k);
    }
}

class Solution189 {
    public void rotate(int[] nums, int k) {
        if(k==0) return;
        k %= nums.length;
        int left = 0;
        int right = nums.length-1;
        int i=k;
        int[] res = new int[nums.length];
        while(left<=right){
            if(k>=1){
                res[k-1] = nums[right];
                k--;
                right--;
            }else{
                res[i] = nums[left];
                i++;
                left++;
            }
        }

        nums = res;
        System.arraycopy(res, 0, nums, 0, nums.length);
    }

    public void rotateSample(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}