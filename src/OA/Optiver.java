package OA;

import com.sun.source.tree.Tree;

import java.util.*;

/**
 * @ClassName Optiver
 * @Description TODO
 * @Author katefu
 * @Date 10/27/22 9:00 PM
 * @Version 1.0
 **/
public class Optiver {
    public static void main(String[] args) {
        String s = "(A,B) (A,C) (B,D) (D,E) (C,F) (E,G)";
        String res = checkTreeError(s);
        System.out.println(res);
    }

    public static String checkTreeError(String s){
        if(s==null || s.length()==0 || !isValid(s)) return "E1"; //check if s is valid

        HashSet<String> pairs = new HashSet<>();
        if(containsDuplicatePair(s, pairs)) return "E2";

        HashSet<Character> nodes = new HashSet<>();
        HashMap<Character, List<Character>> fatherToChildren = new HashMap<>(); //map for key=father, value=list of children
        HashMap<Character, Character> childToFather = new HashMap<>(); //map for key=child, value=father
        if(containsMoreThanTwoChildren(fatherToChildren, childToFather, pairs, nodes)) return "E3";

        char root = findRoot(childToFather, nodes); //if found multiple roots, root='0'
        if(root=='0') return "E4";

        if(hasCircle(fatherToChildren, root, nodes.size())) return "E5";

        //valid binary tree
        TreeNode t = new TreeNode(root);
        buildTree(fatherToChildren, t);
        return sExpression(t);
    }

    public static String sExpression(TreeNode root){
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        preorder(root, sb); //preorder traversal
        return sb.toString();
    }

    public static void preorder(TreeNode root, StringBuilder sb){
        sb.append(root.val);
        if(root.left==null && root.right==null) return;
        if(root.left!=null){
            sb.append("(");
            preorder(root.left, sb);
            sb.append(")");
        }
        if(root.right!=null){
            if(root.left == null) sb.append("()");
            sb.append("(");
            preorder(root.right, sb);
            sb.append(")");
        }
    }

    public static void buildTree(HashMap<Character, List<Character>> fatherToChildren, TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){ //bfs
            TreeNode curNode = queue.poll();
            List<Character> children = fatherToChildren.get(curNode.val);
            if(children==null || children.size()==0) continue;
            if(children.size()==1) curNode.left = new TreeNode(children.get(0)); //if one child, set left
            else{ //if two children, set smaller left, set bigger right
                char c1 = children.get(0);
                char c2 = children.get(1);
                if(c1<c2){
                    curNode.left = new TreeNode(c1);
                    curNode.right = new TreeNode(c2);
                }else{
                    curNode.left = new TreeNode(c2);
                    curNode.right = new TreeNode(c1);
                }
            }
            if(curNode.left!=null) queue.offer(curNode.left);
            if(curNode.right!=null) queue.offer(curNode.right);
        }

    }

    public static boolean hasCircle(HashMap<Character, List<Character>> fatherToChildren, char root, int totalNodes){
        Queue<Character> queue = new LinkedList<>();
        boolean visited[] = new boolean[26];
        queue.offer(root);
        while(!queue.isEmpty()){ //bfs, until all nodes are put in the queue
            char father = queue.poll();
            if(visited[father-'A']) return true; //if child already in queue, find circle
            visited[father-'A'] = true;
            List<Character> children = fatherToChildren.get(father);
            if(children==null || children.size()==0) continue;
            for(char child: children){
                queue.offer(child);
            }
        }
        return false;
    }

    public static char findRoot(HashMap<Character, Character> childToFather, HashSet<Character> nodes){
        char root = '0';
        for(char node: nodes){
            if(!childToFather.containsKey(node)){ //if find a node with no father
                if(root == '0') root = node; //if it is the first one, set root
                else return '0'; //if found one before, raise error for multiple roots
            }
        }
        return root;
    }

    public static boolean containsMoreThanTwoChildren(HashMap<Character, List<Character>> fatherToChildren, HashMap<Character, Character> childToFather, HashSet<String> pairs, HashSet<Character> nodes){
        for(String pair: pairs){ //add pairs into maps
            char father = pair.charAt(1);
            char child = pair.charAt(3);
            nodes.add(father);
            nodes.add(child);
            if(!fatherToChildren.containsKey(father)) fatherToChildren.put(father, new ArrayList<Character>());
            fatherToChildren.get(father).add(child);
            childToFather.put(child, father);
        }

        for(char father: fatherToChildren.keySet()){
            if(fatherToChildren.get(father).size()>2) return true; //check if father has more than two children
        }

        return false;
    }

    public static boolean containsDuplicatePair(String s, HashSet<String> set){
        String[] pairs = s.split(" ");
        for(String pair: pairs){
            if(!set.add(pair)) return true; // if set already contains pair, duplicate
        }
        return false;
    }

    public static boolean isValid(String s){
        if(s.startsWith(" ") || s.endsWith(" ")) return false; //check if s has lead or tail space
        s+=" ";
        if(!s.matches("(\\([A-Z],[A-Z]\\) )+")) return false; //check if s's format is (\\([A-Z],[A-Z]\\) )+
        return true;
    }
}