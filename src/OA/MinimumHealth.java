package OA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName MinimumHealth
 * @Description TODO
 * @Author katefu
 * @Date 10/2/22 4:21 PM
 * @Version 1.0
 **/
public class MinimumHealth {
    public static void main(String[] args) {
        int[] a = new int[]{1,1,3};
        int[] b = new int[]{2,2,4};
        int res = getMinimumHealth(a, b, 2);
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        int res = quickSelect(list, 0, list.size()-1, 2);
        System.out.println(res);
    }
    public static int getMinimumHealth(int[] initialPlayers, int[] newPlayers, int rank){
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<initialPlayers.length; i++){
            list.add(initialPlayers[i]);
        }
        res+=quickSelect(list, 0, initialPlayers.length-1, rank);
        for(int i=0; i<newPlayers.length; i++){
            list.add(newPlayers[i]);
            res+=quickSelect(list, 0, list.size()-1, rank);
        }
        return res;
    }

    public static int quickSelect(List<Integer> nums, int lo, int hi, int k) {
        int p = (int) Math.floor(Math.random() * (hi - lo + 1) + lo);
        Collections.swap(nums, p, hi);
        int i = lo, j = lo;
        while (j < hi) {
            if (nums.get(j) <= nums.get(hi)) {
                Collections.swap(nums, i++, j);
            }
            j++;
        }
        Collections.swap(nums, i, j);
        if (hi == k + i - 1) return nums.get(i);
        else if (hi > k + i - 1) return quickSelect(nums, i + 1, hi, k);
        else return quickSelect(nums, lo, i - 1, k - (hi - i + 1));
    }

}
