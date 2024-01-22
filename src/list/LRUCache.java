package list;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LRUCache
 * @Description TODO
 * @Author katefu
 * @Date 1/22/24 5:05 PM
 * @Version 1.0
 **/



public class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> cache;
    int capacity;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(-1, -1);
        this.right = new Node(-1, -1);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public int get(int key) {
        Node node = cache.getOrDefault(key, null);
        if(node==null) return -1;

        // update
        node.prev.next = node.next;
        node.next.prev = node.prev;
        right.prev.next = node;
        node.prev = right.prev;
        node.next = right;
        right.prev = node;

        return node.value;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        // existing node
        if(cache.containsKey(key)){
            Node updateNode = cache.get(key);
            updateNode.value = value;
            // move to rightmost
            updateNode.prev.next = updateNode.next;
            updateNode.next.prev = updateNode.prev;
            right.prev.next = updateNode;
            updateNode.prev = right.prev;
            updateNode.next = right;
            right.prev = updateNode;
            return;
        }

        // new node
        if(this.cache.size()>= this.capacity){
            // delete leftmost
            Node delete = left.next;
            left.next = delete.next;
            delete.next.prev = left;
            delete.next = null;
            delete.prev = null;
            cache.remove(delete.key);
        }

        // insert rightmost

        right.prev.next = node;
        node.prev = right.prev;
        node.next = right;
        right.prev = node;

        cache.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */