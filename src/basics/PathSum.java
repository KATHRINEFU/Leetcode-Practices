package basics;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2= new TreeNode(2);
//        TreeNode t3 = new TreeNode(8);
//        TreeNode t4 = new TreeNode(11);
//        TreeNode t5 = new TreeNode(13);
//        TreeNode t6 = new TreeNode(4);
//        TreeNode t7 = new TreeNode(7);
//        TreeNode t8 = new TreeNode(2);
//        TreeNode t9 = new TreeNode(1);
        t1.left = t2;
//        t1.right=t3;
//        t2.left=t4;
//        t3.left=t5;
//        t3.right=t6;
//        t4.left=t7;
//        t4.right=t8;
//        t6.right=t9;
        Solution112 test = new Solution112();
        test.hasPathSum(t1,1);

    }
}
class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        return calculate(root, 0, targetSum);
    }

    public boolean calculate(TreeNode root, int sum, int targetSum){
        if(root==null) return sum==targetSum?true:false;
        sum+=root.val;
        return calculate(root.left, sum, targetSum) || calculate(root.right, sum, targetSum);
    }

    public boolean hasPathSumSample(TreeNode root, int targetSum) {
        if(root==null) return false;
        return calculateSample(root, targetSum);
    }

    public boolean calculateSample(TreeNode root, int sum){
        if(root==null) return false;
        if(root.left==null && root.right==null && sum-root.val==0) return true;
        return calculateSample(root.left, sum-root.val) || calculateSample(root.right, sum-root.val);
    }
}