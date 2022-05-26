package binarytree;

import java.util.LinkedList;

/**
 * @ClassName FlattenBinaryTreeToLinkedList
 * @Description Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points
 * to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * @Author katefu
 * @Date 5/26/22 11:19 AM
 * @Version 1.0
 **/
public class FlattenBinaryTreeToLinkedList {
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
class Solution114 {
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        LinkedList<TreeNode> list = new LinkedList<>();
        preOrderTraverse(root, list);
        TreeNode temp = root;
        for(int i=0; i<list.size(); i++){
            temp.right = list.get(i);
            temp.left=null;
            temp = temp.right;
        }
    }

    public void preOrderTraverse(TreeNode root, LinkedList<TreeNode> list){
        if(root==null) return;
        list.add(root);
        preOrderTraverse(root.left, list);
        preOrderTraverse(root.right, list);
    }

    // 定义：将以 root 为根的树拉平为链表
    public void flattenSample(TreeNode root) {
        // base case
        if (root == null) return;

        // 利用定义，把左右子树拉平
        flattenSample(root.left);
        flattenSample(root.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}