package dp;

/**
 * @ClassName HouseRobber
 * @Description
 *     The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 *
 *     Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that
 *     all houses in this place form a binary tree. It will automatically contact the police if two directly-linked
 *     houses were broken into on the same night.
 *
 *     Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 * @Author katefu
 * @Date 5/21/22 11:28 AM
 * @Version 1.0
 **/
public class HouseRobber {
}

class Solution337 {
    public int rob(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.val;
        int[] res = dp(root);
        return Math.max(res[0], res[1]);

    }

    public int[] dp(TreeNode root){
        if(root==null) return new int[]{0,0};
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        int ifRob = root.val+left[0]+right[0];
        int ifNotRob = Math.max(left[0], left[1])+Math.max(right[0], right[1]);
        return new int[]{ifNotRob, ifRob};
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
