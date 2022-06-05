package binarytree;

/**
 * @ClassName CountCompleteTreeNodes
 * @Description Given the root of a complete binary tree, return the number of the nodes in the tree.
 * @Author katefu
 * @Date 6/5/22 11:38 AM
 * @Version 1.0
 **/
public class CountCompleteTreeNodes {
}

class Solution222 {
    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        int hl=0, hr=0;
        while(l!=null){
            hl++;
            l = l.left;
        }
        while(r!=null){
            hr++;
            r = r.right;
        }

        if(hl==hr){
            return (int)Math.pow(2, hl)-1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
