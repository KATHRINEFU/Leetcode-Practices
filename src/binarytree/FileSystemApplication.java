package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FileSystem
 * @Description
 * You are asked to design a file system which provides two functions:
 *
 * createPath(path, value): Creates a new path and associates a value to it if possible and returns True.
 * Returns False if the path already exists or its parent path doesn't exist.
 * get(path): Returns the value associated with a path or returns -1 if the path doesn't exist.
 * The format of a path is one or more concatenated strings of the form: / followed by one or more lowercase English letters. For example, /leetcode and /leetcode/problems are valid paths while an empty string and / are not.
 *
 * Implement the two functions.
 * @Author katefu
 * @Date 10/5/23 10:30 PM
 * @Version 1.0
 **/
public class FileSystemApplication {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        fileSystem.createPath("/leet", 1);
        fileSystem.createPath("/leet/code", 2);
        fileSystem.get("/leet/code");

    }
}

class Solution1166{

}

class FileSystem{
    FileSystemNode root;
    boolean justCreated;

    public FileSystem(){
        root = new FileSystemNode("", -1, new ArrayList<>());
        justCreated = true;
    }


    public boolean createPath(String path, int value){
        //check if parent exist
        justCreated = false;
        if(path.length()<=1) return false;
        if (path.charAt(0) == '/')
            path = path.substring(1);
        String[] paths = path.split("/");

        if(root.children.isEmpty()){
            if(paths.length!=1) return false;
            root.children.add(new FileSystemNode(paths[0], value, new ArrayList<>()));
            return true;
        }
        List<FileSystemNode> nexts = root.children;
        for(FileSystemNode node: nexts){
            if(node.key.equals(paths[0]))
                dfs(node, paths, 1, value);
        }
        return justCreated;
    }

    public int get(String path){
        if(path.length()<=1) return -1;
        if (path.charAt(0) == '/')
            path = path.substring(1);
        String[] paths = path.split("/");

        if(root.children.isEmpty()) return -1;
        List<FileSystemNode> nexts = root.children;
        for(FileSystemNode node: nexts){
            if(node.key.equals(paths[0])) {
                return dfsGet(node, paths, 0);
            }
        }

        return -1;
    }

    public int dfsGet(FileSystemNode root, String[] paths, int i){
        if((root.children==null || root.children.isEmpty()) && i == paths.length-1){
            // tree ends, filename doesn't
            return root.value;
        }else if(root.children==null || root.children.isEmpty()){
            return -1;
        }
        if(root.key.equals(paths[i])){
            for(FileSystemNode node: root.children){
                return dfsGet(node, paths, i+1);
            }
        }

        return -1;
    }


    public void dfs(FileSystemNode root, String[] paths, int i, int value){
        if((root.children==null || root.children.isEmpty()) && i< paths.length-1){
            // tree ends, filename doesn't
            return;
        }
        if(root.children==null || root.children.isEmpty() && i== paths.length-1){
            // valid, add
            FileSystemNode node = new FileSystemNode(paths[i], value, new ArrayList<>());
            root.children.add(node);
            justCreated  = true;
            return;
        }
        if(root.key.equals(paths[i])){
            if(i== paths.length-1) return;
            for(FileSystemNode node: root.children){
                dfs(node, paths, i+1, value);
            }
        }

    }
}

class FileSystemNode{
    String key;
    int value;
    List<FileSystemNode> children;

    public FileSystemNode() {
    }

    public FileSystemNode(String key, int value, List<FileSystemNode> children) {
        this.key = key;
        this.value = value;
        this.children = children;
    }
}


