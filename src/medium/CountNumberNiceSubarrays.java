package medium;

import java.util.*;

public class CountNumberNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        Solution1248 test =  new Solution1248();
        test.numberOfSubarraysSample2(nums,k);
    }
}

class Solution1248 {

    //not true
    public int numberOfSubarrays(int[] nums, int k) {
        int right=0;
        int count=0;
        HashMap<Integer, Integer> map  = new HashMap<>();
        List<Integer> oddIndex = new ArrayList<>();
        int temp=0;

        while(right<nums.length){
            if(nums[right]%2!=0){
                oddIndex.add(right);
                map.put(right, nums[right]);
            }
            if(map.size()==k){
                count+=1+(oddIndex.get(temp));
                map.remove(oddIndex.get(temp));
                temp++;
            }
            right++;
        }

        return count;

    }

    //O(N) for one pass
    public int numberOfSubarraysSample(int[] A, int k) {
        int res = 0, i = 0, count = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            if (A[j] % 2 == 1) {
                --k;
                count = 0;
            }
            while (k == 0) {
                k += A[i++] & 1;
                ++count;
            }
            res += count;
        }
        return res;
    }

    public int numberOfSubarraysSample2(int[] A, int k) {
        return atMost(A, k) - atMost(A, k - 1);
    }

    public int atMost(int[] A, int k) {
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            k -= A[j] % 2;
            while (k < 0)
                k += A[i++] % 2;
            res += j - i + 1;
        }
        return res;
    }

    //deque
    public int numberOfSubarraysSample3(int[] nums, int k) {
        LinkedList<Integer> deq = new LinkedList();
        deq.add(-1);
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 1)
                deq.add(i);
            if (deq.size() > k + 1)
                deq.pop();
            if (deq.size() == k + 1)
                res += (deq.size() > 1 ? deq.get(1) : i) - deq.get(0);
        }
        return res;
    }

    //prefix sum
    //At index i, if current odd numbers from the beginning is M,
    //and we checked there was N previous index with (M - K) oddnum, then we got N subarrays
    //res += N

    public int numberOfSubarraysSample4(int[] nums, int k) {
        int cur = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i] % 2 == 1 ? 1 : 0;
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            ans += map.getOrDefault(cur - k, 0);
        }
        return ans;
    }
}