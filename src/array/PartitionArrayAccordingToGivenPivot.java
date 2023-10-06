package array;

/**
 * @ClassName PartitionArrayAccordingToGivenPivot
 * @Description TODO
 * @Author katefu
 * @Date 9/27/23 3:31 PM
 * @Version 1.0
 **/
public class PartitionArrayAccordingToGivenPivot {
}

class Solution2161 {

    //O(1) space, O(n^2) time
    public int[] pivotArray(int[] nums, int pivot) {
        for(int i=0; i<nums.length; i++){
            int cur = nums[i];
            int k = i;
            int j = i-1;
            if(cur<pivot){
                // keep swapping with previous until reach 0 or number smaller than pivot
                while(j>=0 && nums[j]>=pivot){
                    int tmp = nums[k];
                    nums[k] = nums[j];
                    nums[j] = tmp;
                    k--;
                    j--;
                }

            }else if(cur==pivot){
                //keep swapping until swapped with the last number larger than pivot
                while(j>=0 && nums[j]>pivot){
                    int tmp = nums[k];
                    nums[k] = nums[j];
                    nums[j] = tmp;
                    k--;
                    j--;
                }
            }
        }

        return nums;
    }

    // O(n) Space, O(n) time
    public int[] pivotArraySample(int[] nums, int pivot) {
        int smaller = 0, equal = 0;
        int[] res = new int[nums.length];

        for(int e : nums) {
            if(e < pivot)
                smaller++;
            else if(e == pivot)
                equal++;
        }

        for(int i = 0, j = 0, k = smaller, l = k + equal; i < nums.length; i++) {
            if(nums[i] < pivot)
                res[j++] = nums[i];
            else if(nums[i] == pivot)
                res[k++] = nums[i];
            else
                res[l++] = nums[i];
        }
        return res;
    }
}