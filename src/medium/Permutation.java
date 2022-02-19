package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kate Fu
 * @create: 2022-02-17 21:49
 */
public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution46 test = new Solution46();
        test.permute(nums);
    }
}

class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> in = new ArrayList();
        permute(out, in, nums);
        return out;
    }

    public void permute(List<List<Integer>> out, List<Integer> in, int[] nums){
        if(in.size()==nums.length){
            out.add(new ArrayList<>(in));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(in.contains(nums[i])) continue;
            in.add(nums[i]);
            permute(out,in, nums);
            in.remove(in.size()-1);
        }
    }
}