package binarytree;

/**
 * @ClassName LowestCommonAncestorOfABinaryTree
 * @Description Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * @Author katefu
 * @Date 6/5/22 10:55 AM
 * @Version 1.0
 **/
public class LowestCommonAncestorOfABinaryTree {
}

class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }

    public TreeNode find(TreeNode root, int val1, int val2){
        if(root==null) return null;
        if(root.val== val1 || root.val==val2){
            return root;
        }
        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);
        if(left!=null && right!=null) return root;
        return left!=null?left:right;
    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;

        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        if(root.val >= max){
            //both in left
            return helper(root.left, p, q);
        }
        else if(root.val <= min){
            //both in right
            return helper(root.right, p, q);
        }else{
            // one left, one right
            return root;
        }

    }
}
