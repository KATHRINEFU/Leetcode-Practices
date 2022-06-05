package binarytree;

/**
 * @ClassName UniqueBSTs
 * @Description Given an integer n, return the number of structurally unique BST's (binary search trees)
 * which has exactly n nodes of unique values from 1 to n.
 * @Author katefu
 * @Date 6/4/22 10:30 AM
 * @Version 1.0
 **/
public class UniqueBSTs {
}

class Solution96 {
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n+1][n+1];
        return createTrees(1, n);
    }

    public int createTrees(int lo, int hi){
        if(lo>hi) return 1;
        if(memo[lo][hi]!=0) return memo[lo][hi];
        int res=0;
        for(int i=lo; i<=hi; i++){
            int left = createTrees(lo, i-1);
            int right = createTrees(i+1, hi);
            res+=left*right;
        }
        memo[lo][hi] = res;
        return res;
    }
}