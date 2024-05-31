package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MostFrequentSubtreeSum
 * @Description TODO
 * @Author katefu
 * @Date 5/30/24 8:34 PM
 * @Version 1.0
 **/
public class MostFrequentSubtreeSum {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(-3);
        n1.left = n2;
        n1.right = n3;
        Solution508 test = new Solution508();
        test.findFrequentTreeSum(n1);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> freq = new HashMap<>();
        subTreeSum(root, freq);

        int maxFreq = 0;
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            if(entry.getValue()>maxFreq){
                maxFreq = entry.getValue();
            }else if(entry.getValue() == maxFreq){
            }
        }


        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            if(entry.getValue()==maxFreq){
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public int subTreeSum(TreeNode root, Map<Integer, Integer> freq){
        if(root==null) return 0;
        int left = subTreeSum(root.left, freq);
        int right = subTreeSum(root.right, freq);
        int curSum = root.val + left+ right;
        freq.put(curSum, freq.getOrDefault(curSum, 0)+1);
        return curSum;
    }
}