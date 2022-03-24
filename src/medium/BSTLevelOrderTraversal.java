package medium;

import java.util.ArrayList;
import java.util.List;

public class BSTLevelOrderTraversal {
}

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        levelOrder(out, root,0);
        return out;
    }

    public void levelOrder(List<List<Integer>> out, TreeNode root, int level){
        if(root==null) return;
        if(out.size()==level) out.add(new ArrayList<Integer>());
        out.get(level).add(root.val);
        levelOrder(out, root.left, level+1);
        levelOrder(out, root.right, level+1);
    }

}