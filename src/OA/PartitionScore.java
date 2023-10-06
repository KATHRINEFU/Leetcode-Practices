package OA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName PartitionScore
 * @Description 1. choose an index and add arr[index] to scores
 * 2. dicard left/right partition (can be empty) selected become new arr
 *
 * 说得天花乱坠，本质就是top k。
 * 因为当你选出来top k后， top k 的 K个数字 必然在原数组中有个排列
 * 比如 ...k1...k2...k3...k4..k5... ， 你就按从左到右顺序逐个discard左半边就行了
 * （k1不一定比k2大， 仅仅代表在数组中的相对顺序)
 *
 * @Author katefu
 * @Date 10/2/22 9:41 AM
 * @Version 1.0
 **/
public class PartitionScore {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = new int[]{4,6,-10, -1,10,-20};
        int k = 4;
//        int res = quickSelect(arr, 0, n - 1, 4);
        int res = findMaxScore(n, arr, k);
        System.out.println(res);
    }

    public static int findMaxScore(int n, int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer> topKList = quickSelect(arr, 0, n-1, k, res);
        int score = 0;
        for (Integer i : topKList) {
            System.out.println(i);
        }
        return score;
    }

    public static List<Integer> findTopK(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            if (maxHeap.size() > k) maxHeap.poll();
        }

        List<Integer> topKList = new ArrayList<>(maxHeap);
        Collections.reverse(topKList);

        return topKList;
    }

    public static List<Integer> quickSelect(int[] nums, int lo, int hi, int k, List<Integer> res) {
//        int p = (int) Math.floor(Math.random() * (hi - lo + 1) + lo);
        int p=0;
        swap(nums, p, hi);
        int i = lo, j = lo;
        while (j < hi) {
            if (nums[j] <= nums[hi]) {
                swap(nums, i++, j);
            }
            j++;
        }
        swap(nums, i, j);
        if (hi == k + i - 1) {
            for(int a=i; a<=hi; a++){
                res.add(nums[a]);
            }
            return res;
        }
        else if (hi > k + i - 1) return quickSelect(nums, i + 1, hi, k, res);
        else {
            for(int a=i; a<=hi; a++){
                res.add(nums[a]);
            }
            return quickSelect(nums, lo, i - 1, k - (hi - i + 1), res);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}



