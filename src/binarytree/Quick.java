package binarytree;

import java.util.Random;

/**
 * @ClassName Quick
 * @Description quick sort
 * @Author katefu
 * @Date 6/4/22 11:14 AM
 * @Version 1.0
 **/
public class Quick {
    public static void sort(int[] nums){
        //避免出现耗时的极端情况，先随机打乱
        shuffle(nums);
        sort(nums, 0, nums.length-1);
    }

    private static void sort(int[]nums, int lo, int hi){
        if(lo>=hi) return;
        //对nums[lo...hi]进行切分
        //使nums[lo...p-1]<=nums[p+1...hi]
        int p = partition(nums, lo, hi);
        sort(nums, lo, p-1);
        sort(nums, p+1, hi);
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
