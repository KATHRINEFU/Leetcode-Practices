package basics;

public class SubtreeOfAnotherTree {
}

class Solution572 {
    public boolean isSubtreeSample(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtreeSample(s.left, t) || isSubtreeSample(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    /*
    Solution 2: Serialize in Preorder then KMP
    Serialize binary tree root as string s, serialize binary tree subRoot as string p.
    Check if s contains p using KMP.
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return kmp(serialize(root), serialize(subRoot));
    }
    boolean kmp(String s, String p) { // Check if s contains p?
        int[] lps = getLPS(p);
        int n = s.length(), m = p.length();
        for (int i = 0, j = 0; i < n; ++i) {
            while (s.charAt(i) != p.charAt(j) && j > 0) j = lps[j-1];
            if (s.charAt(i) == p.charAt(j)) j++;
            if (j == m) return true;
        }
        return false;
    }
    int[] getLPS(String p) {
        int m = p.length();
        int[] lps = new int[m];
        for (int i = 1, j = 0; i < m; ++i) {
            while (p.charAt(i) != p.charAt(j) && j > 0) j = lps[j-1];
            if (p.charAt(i) == p.charAt(j)) lps[i] = ++j;
        }
        return lps;
    }
    String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(",#");
        } else {
            sb.append("," + root.val);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }
}