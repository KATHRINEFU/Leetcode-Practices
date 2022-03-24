package basics;

public class LowestCommonAncestor {
}

class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        return root;
    }

    public TreeNode lowestCommonAncestorSample(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestorSample(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestorSample(root.right, p, q);
        }else{
            return root;
        }
    }
}