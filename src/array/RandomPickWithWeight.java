package array;

/**
 * @ClassName RandomPickWithWeight
 * @Description
 *     You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
 *
 *     You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1]
 *     (inclusive) and returns it.The probability of picking an index i is w[i] / sum(w).
 * @Author katefu
 * @Date 5/23/22 11:42 AM
 * @Version 1.0
 **/
public class RandomPickWithWeight {
}

class Solution528 {
    int[] preSum;
    public Solution528(int[] w) {
        preSum = new int[w.length+1];
        preSum[0]=0;
        for(int i=1; i<preSum.length; i++){
            preSum[i] = preSum[i-1]+w[i-1];
        }
    }

    public int pickIndex() {
        int n = preSum.length;
        int target = (int)(Math.random()*preSum[n-1])+1;
        int left=0, right=n;
        int res=-1;
        while(left<right){
            int mid = (right-left)/2+left;
            if(preSum[mid]>target){
                right=mid;
            }else if(preSum[mid]<target){
                left=mid+1;
            }else if(preSum[mid]==target){
                right=mid;
            }
        }
        return left-1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */