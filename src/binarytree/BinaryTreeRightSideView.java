package binarytree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName BinaryTreeRightSideView
 * @Description TODO
 * @Author katefu
 * @Date 7/24/22 5:58 PM
 * @Version 1.0
 **/
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.right = n5;
        n3.right = n4;

        Solution199 test = new Solution199();
        test.rightSideView(n1);
    }
}

class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                size--;
                TreeNode cur = queue.poll();
                if(size==0){
                    res.add(cur.val);
                }
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }

            }
        }

        return res;
    }
}