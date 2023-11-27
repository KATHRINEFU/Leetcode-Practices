package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FrequencyOfTheMostFrequentElement
 * @Description TODO
 * @Author katefu
 * @Date 11/18/23 11:32 AM
 * @Version 1.0
 **/
public class FrequencyOfTheMostFrequentElement {
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        Solution1838 test = new Solution1838();
        test.maxFrequency(nums, 5);

    }
}

class Solution1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> freqMap = new HashMap<>();


        for(int i=0; i<nums.length; i++){
            int j = i;
            int count = 0;
            for(;j<nums.length; j++){
                if(nums[i]==nums[j]){
                    count++;
                }else{
                    break;
                }
            }
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0)+count);

            // now j is the start of next number
            if(j>=nums.length) break;
            int added = 0;
            int b = k;
            for(int a = j-1; a>=0; a--){
                if(b==0) break;
                int gap = nums[j] - nums[a];
                if(b-gap>=0){
                    b-=gap;
                    added++;
                }else{
                    b=0;
                }
            }

            freqMap.put(nums[j], freqMap.getOrDefault(nums[j], 0)+added);
            i=j-1;
        }

        int res = 0;
        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            res = Math.max(res, entry.getValue());
        }
        return res;
    }

    /*
    Lets say we increment k numbers less than x to make them all x. Then operations required will be equal to
    Ops = k * x-sum
    max * size - sum <=k
    so we check: a[j] * (j-i+1) - sum[i:j] <=k

     */
    public int maxFrequencySample(int[] A, int k) {
        int res = 1, i = 0, j;
        long sum = 0;
        Arrays.sort(A);
        for (j = 0; j < A.length; ++j) {
            sum += A[j];
            while (sum + k < (long)A[j] * (j - i + 1)) {
                sum -= A[i];
                i += 1;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}