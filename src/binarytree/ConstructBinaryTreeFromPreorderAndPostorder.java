package binarytree;

import java.util.HashMap;

/**
 * @ClassName ConstructBinaryTreeFromPreorderAndPostorder
 * @Description
 *     Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a
 *     binary tree of distinct values and postorder is the postorder traversal of the same tree,
 *     reconstruct and return the binary tree.
 *
 *     If there exist multiple answers, you can return any of them.
 * @Author katefu
 * @Date 5/26/22 8:27 PM
 * @Version 1.0
 **/
public class ConstructBinaryTreeFromPreorderAndPostorder {
}

class Solution889 {
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }
        int n = postorder.length-1;
        TreeNode root = build(preorder, 0, n, postorder, 0, n);
        return root;
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
        if(preStart>preEnd) return null;
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int index = valToIndex.get(preorder[preStart+1]);
        int leftSize = index - postStart+1;
        root.left = build(preorder, preStart+1, preStart+leftSize, postorder, postStart, index);
        root.right = build(preorder, preStart+leftSize+1, preEnd, postorder, index+1, postEnd);
        return root;
    }
}