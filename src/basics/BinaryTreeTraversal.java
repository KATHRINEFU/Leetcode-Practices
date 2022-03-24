package basics;

import java.util.*;

public class BinaryTreeTraversal {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right=t2;
        t2.left=t3;
        Solution94 test = new Solution94();
        test.inorderTraversal(t1);
        test.postorderTraversal(t1);
    }
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

class Solution94 {
    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> rights = new Stack<TreeNode>();
        while(node != null) {
            list.add(node.val);
            if (node.right != null) {
                rights.push(node.right);
            }
            node = node.left;
            if (node == null && !rights.isEmpty()) {
                node = rights.pop();
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ans;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ans;
    }

    //Morris Traversal is a way of traversing BST with O(1) space and O(n) time.
    // It's a little hard to understand but the basic idea is to link predecessor back to current node
    // so that we can trace back to top of BST. It's also a little tricky to see how it is O(n) since
    // finding predecessor is often O(logn). The answer is , we don't have to find predecessor for every node,
    // only the nodes with valid left child. It will be obvious if you draw a tree to see that every edge is
    // only visited constant time.
    //https://zhuanlan.zhihu.com/p/101321696

    public static List<Integer> inorderMorris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode p = cur.left;
                while (p.right != null && p.right != cur) {
                    p = p.right;
                }
                if (p.right == null) {
                    p.right = cur;
                    cur = cur.left;
                } else {
                    p.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    public static List<Integer> preorderMorris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            }
            else {
                TreeNode p = cur.left;
                while (p.right != null && p.right != cur) {
                    p = p.right;
                }
                if (p.right == null) {
                    p.right = cur;
                    res.add(cur.val);
                    cur = cur.left;
                }
                else {
                    p.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    public static List<Integer> postorderMorris(TreeNode root) {
        Deque<Integer> res = new ArrayDeque<>();
        if (root == null) return new ArrayList<>(res);
        TreeNode cur = root;
        while (cur != null) {
            if (cur.right != null) {
                TreeNode p = cur.right;
                while (p.left != null && p.left != cur) {
                    p = p.left;
                }
                if (p.left == null) {
                    p.left = cur;
                    res.addFirst(cur.val);
                    cur = cur.right;
                }
                else {
                    p.left = null;
                    cur = cur.left;
                }
            }
            else {
                res.addFirst(cur.val);
                cur = cur.left;
            }
        }
        return new ArrayList<>(res);
    }
}