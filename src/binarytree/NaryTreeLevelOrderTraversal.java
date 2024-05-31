package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName NaryTreeLevelOrderTraversal
 * @Description TODO
 * @Author katefu
 * @Date 5/9/24 7:58 PM
 * @Version 1.0
 **/
public class NaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        NaryNode n1 = new NaryNode(1);
        NaryNode n2 = new NaryNode(3);
        NaryNode n3 = new NaryNode(2);
        NaryNode n4 = new NaryNode(4);
        NaryNode n5 = new NaryNode(5);
        NaryNode n6 = new NaryNode(6);

        List<NaryNode> level2 = new ArrayList<>();
        level2.add(n2);
        level2.add(n3);
        level2.add(n4);

        List<NaryNode> level3 = new ArrayList<>();
        level3.add(n5);
        level3.add(n6);

        n1.children = level2;
        n2.children = level3;

        Solution429 test =  new Solution429();
        test.levelOrder(n1);


    }
}

class Solution429 {
    public List<List<Integer>> levelOrder(NaryNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        Queue<NaryNode> queue = new LinkedList<>();
        if(root==null) return res;

        level.add(root.val);
        res.add(new ArrayList<>(level));
        level.clear();

        int levelNum = 1;
        queue.offer(root);
        while(!queue.isEmpty()){
            int nextLevelNum = 0;
            for(int j=0; j<levelNum; j++){
                NaryNode cur = queue.poll();
                if(cur.children==null){
                    continue;
                }
                nextLevelNum += cur.children.size();
                for(int i=0; i<cur.children.size(); i++){
                    if(cur.children.get(i)!=null){
                        queue.add(cur.children.get(i));
                        level.add(cur.children.get(i).val);
                    }
                }
            }
            if(level!=null){
                res.add(new ArrayList<>(level));
                level.clear();
            }
            levelNum = nextLevelNum;
        }

        return res;
    }
}

class NaryNode {
    public int val;
    public List<NaryNode> children;

    public NaryNode() {}

    public NaryNode(int _val) {
        val = _val;
    }

    public NaryNode(int _val, List<NaryNode> _children) {
        val = _val;
        children = _children;
    }
};