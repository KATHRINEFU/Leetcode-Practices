package binarytree;

import java.util.HashMap;

/**
 * @ClassName PathSum3
 * @Description
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 * @Author katefu
 * @Date 7/16/22 3:22 PM
 * @Version 1.0
 **/
public class PathSum3 {
    public static void main(String[] args) {

    }
}

class Solution437 {
    int res = 0;
    int target = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        target = targetSum;
        traverse(root, targetSum);
        return res;
    }

    public void traverse(TreeNode root, int remain){
        if(root==null) return;
        if(remain<0) remain = target;
        if(remain==0){
            res++;
            remain = target;
        }
        traverse(root.left, remain-root.val);
        traverse(root.right, remain-root.val);
    }

    // prefix Sum + long!
    public int pathSumSample(TreeNode root, int targetSum) {
        HashMap<Long, Integer> preSum = new HashMap();
        preSum.put(0L,1);
        helper(root, 0, targetSum, preSum);
        return count;
    }

    int count = 0;
    public void helper(TreeNode root, long currSum, int target, HashMap<Long, Integer> preSum) {
        if (root == null) {
            return;
        }

        currSum += root.val;

        if (preSum.containsKey(currSum - target)) {
            count += preSum.get(currSum - target);
        }

        if (!preSum.containsKey(currSum)) {
            preSum.put(currSum, 1);
        } else {
            preSum.put(currSum, preSum.get(currSum)+1);
        }

        helper(root.left, currSum, target, preSum);
        helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
    }
}
