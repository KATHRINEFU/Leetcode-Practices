package array;

import java.util.Arrays;

/**
 * @ClassName Sum3Closest
 * @Description
 *    Given an integer array nums of length n and an integer target,
 *    find three integers in nums such that the sum is closest to target.
 *    Return the sum of the three integers.
 *    You may assume that each input would have exactly one solution.
 * @Author katefu
 * @Date 5/9/22 10:11 AM
 * @Version 1.0
 **/
public class Sum3Closest {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-5,3,-4};
        int target = -1;
        Solution16 test =  new Solution16();
        int res = test.threeSumClosest(nums, target);
        System.out.println(res);
//        int a = Integer.MIN_VALUE;
//        int b = -6;
//        System.out.println(Math.abs(-1-a));
//        System.out.println(Math.abs(-1-b));
    }

}

class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length==3) return nums[0]+nums[1]+nums[2];
        int res=10000000;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int temp = nums[i]+nums[j]+nums[k];
                if(Math.abs(target-temp)<Math.abs(target-res)){
                    res = temp;
                }
                if(temp<target) j++;
                else if(temp>target) k--;
                else{
                    res = temp;
                    return res;
                }
            }
        }

        return res;
    }
}