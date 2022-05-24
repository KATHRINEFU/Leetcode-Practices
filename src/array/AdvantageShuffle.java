package array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName AdvantageShuffle
 * @Description
 *    You are given two integer arrays nums1 and nums2 both of the same length.
 *    The advantage of nums1 with respect to nums2 is the number of indices i for which nums1[i] > nums2[i].
 *
 *    Return any permutation of nums1 that maximizes its advantage with respect to nums2.
 * @Author katefu
 * @Date 5/24/22 10:52 AM
 * @Version 1.0
 **/
public class AdvantageShuffle {
}

class Solution870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> {
                    return pair2[1] - pair1[1];
                }
        );
        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[]{i, nums2[i]});
        }

        int left=0;
        int right=n-1;
        int[] res = new int[n];

        while (!maxpq.isEmpty()) {
            int[] pair = maxpq.poll();
            // maxval 是 nums2 中的最大值，i 是对应索引
            int i = pair[0], maxval = pair[1];
            if (maxval < nums1[right]) {
                // 如果 nums1[right] 能胜过 maxval，那就自己上
                res[i] = nums1[right];
                right--;
            } else {
                // 否则用最小值混一下，养精蓄锐
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }
}


