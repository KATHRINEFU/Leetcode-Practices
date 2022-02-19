package basics;

/**
 * @author: Kate Fu
 * @create: 2021-12-29 18:07
 */
public class maxSubArray {
    public static void main(String[] args) {
        int[] nums={1,-9,2,3,-6,0,5,2};
        int res = helper(nums, 0, nums.length-1);
        System.out.println(res);
    }

    public static int helper(int nums[],int i,int j){

        if(i==j){
            return nums[i];
        }

        int mid  =  (i+j)/2;
        int sum = 0,leftMax = Integer.MIN_VALUE;

        for(int l =  mid;l>=i;l--){
            sum+=nums[l];
            if(sum>leftMax){
                leftMax =  sum;
            }
        }

        int rightMax = Integer.MIN_VALUE;
        sum = 0;    // reset sum to 0
        for (int l = mid + 1; l <=j; l++)
        {
            sum += nums[l];
            if (sum > rightMax) {
                rightMax = sum;
            }
        }

        int maxLeftRight = Math.max(helper(nums, i, mid),
                helper(nums, mid + 1, j ));
        return Math.max(maxLeftRight, leftMax + rightMax);
    }

    //Kadane's algorithm
    public int maxSubArraySample(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;

        for(int i=0;i<n;i++){
            sum += nums[i];
            max = Math.max(sum,max);

            if(sum<0) sum = 0;
        }

        return max;
    }
}
