package basics;

import java.util.HashSet;

/**
 * @author: Kate Fu
 * @create: 2022-01-21 13:56
 */
public class containsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        Solution217 test = new Solution217();
        boolean res = test.containsDuplicate(nums);
        System.out.println(res);
    }
}

class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int i:nums){
            if(!set.add(i)) return false;
        }
        return true;
    }
}