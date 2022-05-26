package binarytree;

/**
 * @ClassName PopulatingNextRightPointers
 * @Description Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 * @Author katefu
 * @Date 5/26/22 10:42 AM
 * @Version 1.0
 **/
public class PopulatingNextRightPointers {
}


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution116 {
    public Node connect(Node root) {
        if(root==null) return root;
        traverse(root.left, root.right);
        return root;
    }

    public void traverse(Node left, Node right){
        if(left==null || right == null) return;
        left.next = right;
        traverse(left.left, left.right);
        traverse(right.left, right.right);
        traverse(left.right, right.left);
    }
}
