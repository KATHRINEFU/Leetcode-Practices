package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName BinaryTreesWithFactors
 * @Description TODO
 * @Author katefu
 * @Date 10/25/23 9:12 PM
 * @Version 1.0
 **/
public class BinaryTreesWithFactors {
    public static void main(String[] args) {
        int[] arr = {18,3,6,2};
        Solution823 test = new Solution823();
        test.numFactoredBinaryTrees(arr);
    }
}


class Solution823 {
    public int numFactoredBinaryTrees(int[] arr) {
        int res = 0;
        Arrays.sort(arr);
        int[] dp = new int[arr.length];
        Set<Integer> set = new HashSet<>();
        for(int num: arr){
            set.add(num);
        }
        // number of binary trees for elements ending with arr[i];
        // for a[0]-2: only 2;
        Arrays.fill(dp, 1);
        for(int i=1;i<arr.length; i++){
            for(int j=0; j<i; j++){
                if(arr[i]%arr[j]==0){
                    if(set.contains(arr[i]/arr[j])){
                        dp[i]+=1;
                    }
                }
            }
        }

        for(int num: dp){
            res += num;
        }

        return res;
    }

    public int numFactoredBinaryTreesLee(int[] A) {
        long res = 0L, mod = (long)1e9 + 7;
        Arrays.sort(A);
        HashMap<Integer, Long> dp = new HashMap<>();
        for (int i = 0; i < A.length; ++i) {
            dp.put(A[i], 1L);
            for (int j = 0; j < i; ++j)
                if (A[i] % A[j] == 0)
                    dp.put(A[i], (dp.get(A[i]) + dp.get(A[j]) * dp.getOrDefault(A[i] / A[j], 0L)) % mod);
            res = (res + dp.get(A[i])) % mod;
        }
        return (int) res;
    }
}