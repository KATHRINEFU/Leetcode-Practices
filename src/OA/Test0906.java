package OA;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test0906
 * @Description
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 n/2 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例1：
 * 输入：[3,2,3]
 * 输出：3
 *
 * 示例2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * @Author katefu
 * @Date 9/6/22 10:08 PM
 * @Version 1.0
 **/
public class Test0906 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        Solution s = new Solution();
        int res = s.test(nums);
        System.out.println(res);
    }

}

class Solution{
    public int test(int[] nums){
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()>n/2){
                return entry.getKey();
            }
        }

        return 0;
    }
}
