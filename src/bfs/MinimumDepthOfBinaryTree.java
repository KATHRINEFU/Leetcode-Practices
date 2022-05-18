package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MinimumDepthOfBinaryTree
 * @Description TODO
 * @Author katefu
 * @Date 5/18/22 7:38 PM
 * @Version 1.0
 **/
public class MinimumDepthOfBinaryTree {

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
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth=1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();
                if(cur.left==null && cur.right==null) return depth;
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }
}
