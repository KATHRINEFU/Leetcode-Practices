package binarytree;

/**
 * @ClassName CountNodesEqualToAverageOfSubtree
 * @Description TODO
 * @Author katefu
 * @Date 11/3/23 3:01 PM
 * @Version 1.0
 **/
public class CountNodesEqualToAverageOfSubtree {
    public static void main(String[] args) {
        Solution2265 test = new Solution2265();
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(0);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(6);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;

        test.averageOfSubtree(t1);
    }
}

class Solution2265 {
    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        postOrder(root, 0, 0);
        return count;
    }

    public int[] postOrder(TreeNode root, int curNodeNum, int curNodeSum){
        if(root==null) return new int[]{0,0};

        // left subtree sum
        int[] leftInfo = postOrder(root.left, curNodeNum+1, curNodeSum+root.val);
        int leftSum = leftInfo[0];
        int leftNodes = leftInfo[1];

        // right subtree sum
        int[] rightInfo = postOrder(root.right, curNodeNum+1, curNodeSum+root.val);
        int rightSum = rightInfo[0];
        int rightNodes = rightInfo[1];
        // current root sum

        // check
        if((leftSum+rightSum+root.val)/(leftNodes+rightNodes+1) == root.val){
            count++;
        }

        return new int[]{leftSum+rightSum+root.val, leftNodes+rightNodes+1};
    }
}