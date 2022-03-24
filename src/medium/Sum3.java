package medium;

import java.util.*;

public class Sum3 {
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3) return new ArrayList<>();
        Set<List<Integer>> res  = new HashSet<>();
        Arrays.sort(nums);
        if(nums[0]>0 || nums[nums.length-1]<0) return new ArrayList<>();
        int left=0;
        int right = nums.length-1;

        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0) res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if ( sum >0) k--;
                else if (sum<0) j++;
            }
        }
        return new ArrayList<>(res);

    }
}
