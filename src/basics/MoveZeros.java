package basics;

/**
 * @author: Kate Fu
 * @create: 2022-02-09 16:50
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        Solution283 test = new Solution283();
        test.moveZeroes(nums);
    }
}

class Solution283 {
    public void moveZeroes(int[] nums) {
        if(nums.length==1) return;
        int left=0;
        int right = nums.length-1;
        while(left<=right){
            if(nums[left]==0){
                moveToBack(nums, left);
                right--;
            }else{
                left++;
            }
        }
    }

    public void moveToBack(int[] nums, int i){
        int temp = nums[i];
        for(int j=i; j<nums.length-1; j++){
            nums[j] = nums[j+1];
        }
        nums[nums.length-1]=temp;
    }

    public void moveZerosSample(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}