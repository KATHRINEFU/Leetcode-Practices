package medium;

/**
 * @author: Kate Fu
 * @create: 2022-02-15 19:33
 */
public class PopulatingNextRightPointers {

}
class Solution116 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode level_start=root;
        while(level_start!=null){
            TreeLinkNode cur=level_start;
            while(cur!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;

                cur=cur.next;
            }
            level_start=level_start.left;
        }
    }
}

class TreeLinkNode {
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode() {}

    public TreeLinkNode(int _val) {
        val = _val;
    }

    public TreeLinkNode(int _val, TreeLinkNode _left, TreeLinkNode _right, TreeLinkNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};