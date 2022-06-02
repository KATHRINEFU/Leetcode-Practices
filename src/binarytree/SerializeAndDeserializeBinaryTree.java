package binarytree;

import java.util.LinkedList;

/**
 * @ClassName SerializeAndDeserializeBinaryTree
 * @Description
 *     Design an algorithm to serialize and deserialize a binary tree.
 *     There is no restriction on how your serialization/deserialization algorithm should work.
 *     You just need to ensure that a binary tree can be serialized to a string and this string
 *     can be deserialized to the original tree structure.
 * @Author katefu
 * @Date 5/27/22 11:11 AM
 * @Version 1.0
 **/
public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        String s = "1,2,#,4,#,#,3,#,#";
        Codec test = new Codec();
        test.deserialize(s);
    }
}/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Codec {
    String sep = ",";
    String nul = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(sb, root);
        return sb.toString();
    }

    public void serialize(StringBuilder sb, TreeNode root){
        if(root==null){
            sb.append(nul).append(sep);
            return;
        }

        sb.append(root.val).append(sep);
        serialize(sb, root.left);
        serialize(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         LinkedList<String> nodes = new LinkedList<>();
         for(String s: data.split(sep)){
             nodes.addLast(s);
         }
//        StringBuilder sb = new StringBuilder();
//        TreeNode root = new TreeNode();
//        sb.append(data);
//        deserialize(sb,0, sb.length(), root);
        return deserialize(nodes);
    }

    public void deserialize(StringBuilder sb, int start, int end, TreeNode root){
        if(start>end){
            return;
        }
        int rootIndex = sb.indexOf(sep);
        root.val = Integer.parseInt(sb.substring(start, rootIndex));
        int leftIndex = sb.indexOf(null+sep+null)+2;


        deserialize(sb, rootIndex+1, leftIndex, root.left);
        deserialize(sb, leftIndex+1, end, root.right);
    }

    public TreeNode deserialize(LinkedList<String> nodes){
        if(nodes.isEmpty()) return null;
        String first = nodes.removeFirst();
        if(first.equals(nul)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));


