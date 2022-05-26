package binarytree;

import java.util.HashMap;

/**
 * @ClassName ConstructBinaryTreeFromPreorderAndInorder
 * @Description TODO
 * @Author katefu
 * @Date 5/26/22 3:42 PM
 * @Version 1.0
 **/
public class ConstructBinaryTreeFromPreorderAndInorder {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution105 {
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==1) return new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        int n = preorder.length-1;
        TreeNode root = build(preorder, 0, n, inorder, 0, n);
        return root;
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart>preEnd) return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = valToIndex.get(rootVal);
        int leftSize = index-inStart;
        root.left = build(preorder, preStart+1, preStart+leftSize, inorder, inStart, index-1);
        root.right = build(preorder, preStart+1+leftSize, preEnd, inorder, index+1, inEnd);
        return root;
    }
}