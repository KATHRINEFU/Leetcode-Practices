
package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kate Fu
 * @create: 2022-02-18 19:47
 */
public class Triangle {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(-1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(3);
        List<Integer> l3 = new ArrayList<>();
        l3.add(1);
        l3.add(-1);
        l3.add(-3);
        List<List<Integer>> input = new ArrayList<>();
        input.add(l1);
        input.add(l2);
        input.add(l3);
        Solution120 test = new Solution120();
        test.minimumTotal(input);

    }
}
class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1) return triangle.get(0).get(0);
        int[] dp = new int[triangle.size()+1];
        int[] index = new int[triangle.size()+1];
        dp[0] = triangle.get(0).get(0);
        index[0]=0;
        if(triangle.get(1).get(0)>triangle.get(1).get(1)){
            dp[1]=triangle.get(1).get(1);
            index[1] = 1;
        }
        else{
            dp[1]=triangle.get(1).get(0);
            index[1]=0;
        }

        for(int i=2; i<triangle.size(); i++){
            if(triangle.get(i).get(index[i-1]) > triangle.get(i).get(index[i-1]+1)){
                dp[i] = triangle.get(i).get(index[i-1]+1);
                index[i]=index[i-1]+1;
            }else{
                dp[i]=triangle.get(i).get(index[i-1]);
                index[i] = index[i-1];
            }
        }

        int sum=0;
        for(int i=0; i<dp.length; i++){
            sum+=dp[i];
        }

        return sum;
    }

    //from bottom to top
    //'Bottom-up' DP, on the other hand, is very straightforward: we start from the nodes on the bottom row;
    // the min pathsums for these nodes are the values of the nodes themselves. From there, the min pathsum at
    // the ith node on the kth row would be the lesser of the pathsums of its two children plus the value of itself,
    // minpath[k][i] = min( minpath[k+1][i], minpath[k+1][i+1]) + triangle[k][i];

    //Or even better, since the row minpath[k+1] would be useless after minpath[k] is computed, we can simply
    // set minpath as a 1D array, and iteratively update itself:
    //minpath[i] = min( minpath[i], minpath[i+1]) + triangle[k][i];


    public int minimumTotalSample(List<List<Integer>> triangle) {
        // corner case
        if(triangle == null || triangle.size() == 0) return 0;

        // M[i] represents the min total from bottom to current position
        // copy the last row in triangle to M
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[] M = new int[n];
        for(int i = 0; i < n; i++){
            M[i] = triangle.get(m - 1).get(i);
        }

        // induction rule
        // M[i] = min(M[i], M[i + 1]) + curVal
        for(int i = n - 2; i >= 0; i--){
            List<Integer> cur = triangle.get(i);
            for(int j = 0; j < cur.size(); j++){
                M[j] = Math.min(M[j], M[j + 1]) + cur.get(j);
            }
        }

        return M[0];
    }

    //from top to bottom
    public int minimumTotalSample2(List<List<Integer>> triangle) {
        // corner case
        if(triangle == null || triangle.size() == 0) return 0;

        // M[i] represents the min total from bottom to current position
        int m = triangle.size();
        int n = triangle.get(m - 1).size(); // last row size
        int[] M = new int[n];
        M[0] = triangle.get(0).get(0);

        // induction rule
        // M[j] = min(M[j - 1], M[j]) + curVal
        for(int i = 1; i < m; i++){
            List<Integer> cur = triangle.get(i);
            for(int j = cur.size() - 1; j >= 0; j--){
                if(j == 0){
                    M[0] = M[0] + cur.get(j);
                }else if(j == cur.size() - 1){
                    M[j] = M[j - 1] + cur.get(j);
                }else{
                    M[j] = Math.min(M[j - 1], M[j]) + cur.get(j);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min, M[i]);
        }

        return min;
    }
}