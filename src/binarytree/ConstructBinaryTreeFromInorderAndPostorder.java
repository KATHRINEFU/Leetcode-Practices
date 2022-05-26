package binarytree;

import java.util.HashMap;

/**
 * @ClassName ConstructBinaryTreeFromInorderAndPostorder
 * @Description TODO
 * @Author katefu
 * @Date 5/26/22 5:06 PM
 * @Version 1.0
 **/
public class ConstructBinaryTreeFromInorderAndPostorder {
    public static void main(String[] args) {
        int[] in = {9,3,15,20,7};
        int[] post = {9,15,7,20,3};
        Solution106 test  = new Solution106();
        test.buildTree(in, post);
    }
}

class Solution106 {
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        int n = postorder.length-1;
        TreeNode root = build(postorder, 0, n, inorder, 0, n);
        return root;
    }

    public TreeNode build(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd){
        if(postStart>postEnd) return null;
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = valToIndex.get(rootVal);
        int leftSize = index - inStart;
        root.left = build(postorder, postStart, postStart+leftSize-1, inorder, inStart, index-1);
        root.right = build(postorder, postStart+leftSize, postEnd-1, inorder, index+1, inEnd);
        return root;
    }
}
