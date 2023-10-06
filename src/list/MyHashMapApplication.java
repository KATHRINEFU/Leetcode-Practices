package list;

/**
 * @ClassName MyHashMapApplication
 * @Description TODO
 * @Author katefu
 * @Date 10/4/23 1:56 PM
 * @Version 1.0
 **/
public class MyHashMapApplication {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        map.get(1);
        map.get(3);
        map.put(2, 1);
        map.remove(2);
        map.get(2);
    }
}

class MyHashMap {
    final MapListNode[] nodes;

    public MyHashMap() {
        nodes = new MapListNode[100];
    }

    public void put(int key, int value) {
        int i = hash(key);
        MapListNode now = nodes[i];
        MapListNode tmp = now;
        if(tmp!=null){
            MapListNode prev = null;
            while(tmp!=null){
                if(tmp.key == key){
                    tmp.value = value;
                    return;
                }
                prev = tmp;
                tmp = tmp.next;
            }
            tmp = prev;
        }

        MapListNode node = new MapListNode(key, value);
        if(tmp!=null){
            tmp.next = node;
        }else{
            nodes[i] = node;
        }
    }

    private int hash(int key){
        return Integer.hashCode(key) % nodes.length;
    }

    public int get(int key) {
        int i = hash(key);
        MapListNode now = nodes[i];
        if(now != null){
            if(now.key == key) return now.value;
            while(now!=null){
                if(now.key == key) return now.value;
                now = now.next;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int i = hash(key);
        MapListNode now = nodes[i];

        if(now!=null){
            MapListNode prev = null;
            while(now!=null){
                if(now.key == key){
                    if(prev!=null){
                        prev.next = now.next;
                    }else{
                        nodes[i] = now.next;
                    }

                    now.next = null;
                    return;
                }
                prev = now;
                now = now.next;
            }
        }
    }
}

class MapListNode{
    int key, value;
    MapListNode next;

    MapListNode(int key, int val){
        this.key = key;
        this.value = val;
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
