package binarytree;

/**
 * @ClassName MaximumBinaryTree
 * @Description
 *    You are given an integer array nums with no duplicates.
 *    A maximum binary tree can be built recursively from nums using the following algorithm:
 *
 * Create a root node whose value is the maximum value in nums.
 * Recursively build the left subtree on the subarray prefix to the left of the maximum value.
 * Recursively build the right subtree on the subarray suffix to the right of the maximum value.
 * Return the maximum binary tree built from nums.
 * @Author katefu
 * @Date 5/26/22 11:56 AM
 * @Version 1.0
 **/
public class MaximumBinaryTree {
}


class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums,int start, int end){
        if(start>end) return null;
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, start, index-1);
        root.right = build(nums, index+1, end);
        return root;
    }
}
