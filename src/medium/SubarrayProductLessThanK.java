package medium;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        Solution713 test = new Solution713();
        int count = test.numSubarrayProductLessThanK(nums,19);
        System.out.println(count);
    }
}

class Solution713 {
    // wrong answer in large nums
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0) return 0;
        int windowLen = 1;
        int count=0;
        boolean flag=false;
        for(; windowLen<=nums.length; windowLen++){
            if(windowLen!=1 && flag==false){
                break;
            }
            //initial window
            int product=1;
            flag=false;
            for(int i=0; i<windowLen; i++){
                product = product*nums[i];
            }
            if(product<k) {
                count++;
                flag=true;
            }
            //sliding window
            for(int i=windowLen; i<nums.length; i++){
                product = product/nums[i-windowLen];
                product = product*nums[i];
                if(product<k) {
                    count++;
                    flag=true;
                }
            }
        }
        return count;
    }

    public int numSubarrayProductLessThanKSample(int[] nums, int k) {
        if (k == 0) return 0;
        int cnt = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];
            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt;
    }
}