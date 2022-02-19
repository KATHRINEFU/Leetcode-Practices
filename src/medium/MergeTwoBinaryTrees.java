package medium;

/**
 * @author: Kate Fu
 * @create: 2022-02-15 15:34
 */
public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        TreeNode1 n1 = new TreeNode1(1);
        TreeNode1 n2 = new TreeNode1(3);
        TreeNode1 n3 = new TreeNode1(2);
        TreeNode1 n4 = new TreeNode1(5);

        n1.left = n2;
        n1.right=n3;
        n2.left=n4;

        TreeNode1 r1 = new TreeNode1(2);
        TreeNode1 r2 = new TreeNode1(1);
        TreeNode1 r3 = new TreeNode1(3);
        TreeNode1 r4 = new TreeNode1(4);
        TreeNode1 r5 = new TreeNode1(7);
        r1.left=r2;
        r1.right=r3;
        r2.right=r4;
        r3.right=r5;

        Solution617 test = new Solution617();
        test.mergeTrees(n1,r1);
    }
}

class Solution617 {
    public TreeNode1 mergeTrees(TreeNode1 root1, TreeNode1 root2) {
        root1.val = root1.val+root2.val;
        traverse(root1, root2);
        return root1;
    }

    public void traverse(TreeNode1 node1, TreeNode1 node2){
        if(node1==null || node2==null) return;
        if(node1.left==null && node1.right==null && node2.left==null && node2.right==null)
            return;

        if(node1.left!=null && node2.left!=null){
            node1.left.val = node1.left.val+node2.left.val;
        }else if(node1.left==null && node2.left!=null){
            node1.left = node2.left;
        }

        if(node1.right!=null && node2.right!=null){
            node1.right.val = node1.right.val+node2.right.val;
        }else if(node1.right==null && node2.right!=null){
            node1.right = node2.right;
        }

        traverse(node1.left, node2.left);
        traverse(node1.right, node2.right);
    }

    public TreeNode1 mergeTreesSample(TreeNode1 t1, TreeNode1 t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode1 result = new TreeNode1(t1.val + t2.val);
        result.left = mergeTreesSample(t1.left, t2.left);
        result.right = mergeTreesSample(t1.right, t2.right);
        return result;
    }
}

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}