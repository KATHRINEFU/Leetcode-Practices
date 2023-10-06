package array;

/**
 * @ClassName FindPivotIndex
 * @Description TODO
 * @Author katefu
 * @Date 6/23/23 9:31 PM
 * @Version 1.0
 **/
public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution724 test = new Solution724();
        int res = test.pivotIndex(nums);
        System.out.println(res);
    }
}

class Solution724 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] preNum = new int[n];

        preNum[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            preNum[i] = preNum[i-1] + nums[i];
        }

        for(int i=0; i<n; i++){
            if(preNum[i] - nums[i]==preNum[n-1]-preNum[i]) return i;
        }

        return -1;
    }
}