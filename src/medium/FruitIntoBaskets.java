package medium;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2};
        Solution904 test  = new Solution904();
        test.totalFruitSample(nums);

    }
}

class Solution904 {
    public int totalFruit(int[] fruits) {
        int res=0;
        int sum=0;
        int type1 = fruits[0];
        int type2 = fruits[1];
        for(int end=0; end<fruits.length; end++){
            sum++;

            while(end <fruits.length-1 && (fruits[end]==type1 || fruits[end]==type2)){
                end++;
                sum++;
            }
            res = sum>res? sum:res;

            if(end==fruits.length) break;
            sum=0;
            type1 = fruits[end-1];
            type2 = fruits[end];
        }
        return res;
    }

    public int totalFruitSample(int[] tree) {
        Map<Integer, Integer> count = new HashMap<>();
        int i = 0, j;
        for (j = 0; j < tree.length; ++j) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            if (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                count.remove(tree[i++], 0);
            }
        }
        return j - i;
    }

    public int totalFruitSample2(int[] tree) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0, i = 0;
        for (int j = 0; j < tree.length; ++j) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            while (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                if (count.get(tree[i]) == 0) count.remove(tree[i]);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
