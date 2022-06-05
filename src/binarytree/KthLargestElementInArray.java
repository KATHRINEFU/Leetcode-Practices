package binarytree;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @ClassName KthLargestElementInArray
 * @Description Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * @Author katefu
 * @Date 6/4/22 3:21 PM
 * @Version 1.0
 **/
public class KthLargestElementInArray {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k=4;
        Solution215 test = new Solution215();
        int res = test.findKthLargest(nums,k);
        System.out.println(res);
    }
}

class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i=nums.length-1; i>=0; i--){
            if(i==nums.length-k) return nums[i];
        }
        return -1;
    }

    //二叉堆 时间O(Nlogk) 空间O(k)
    public int findKthLargestSample1(int[] nums, int k){
        //堆顶是最小元素
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int e:nums){
            pq.offer(e);
            //堆中元素多于k个是，删除堆顶元素
            if(pq.size()>k) pq.poll();
        }
        //pq剩下的是nums中k个最大元素
        //堆顶是堆小的那个，即第k大的
        return pq.peek();
    }

    //快速选择 O(N)
    public int findKthLargestSample2(int[] nums, int k){
        shuffle(nums);
        int lo=0, hi=nums.length-1;
        k = nums.length-k;
        while(lo<hi){
            int p = partition(nums, lo, hi);
            if(p<k) lo=p+1;//第k大的元素在nums[p+1...hi]中
            else if(p>k) hi = p-1;
            else return nums[p];
        }
        return -1;
    }

    private static int partition(int[] nums, int lo, int hi){
        int pivot = nums[lo];
        //定义i，j为开区间，同时定义
        //[lo,i)<=pivot; (j,hi]>=pivot
        int i=lo+1, j=hi;
        while(i<=j){
            while(i<hi && nums[i]<=pivot){
                i++;
                //此while结束时恰好nums[i]>pivot
            }
            while(j>lo && nums[j]>pivot){
                j--;
                //此while结束时恰好nums[j]<=pivot
            }
            // 此时[lo, i)<=pivot &&(j, hi]>pivot
            if(i>=j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private static void shuffle(int[] nums){
        Random rand = new Random();
        int n = nums.length;
        for(int i=0; i<n; i++){
            //生成[i, n-1]的随机数
            int r = i+rand.nextInt(n-1);
            swap(nums, i, r);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
