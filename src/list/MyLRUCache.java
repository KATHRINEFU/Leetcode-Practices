package list;

/**
 * @ClassName MyLRUCache
 * @Description TODO
 * @Author katefu
 * @Date 1/22/24 5:06 PM
 * @Version 1.0
 **/
public class MyLRUCache {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        System.out.println(lRUCache.get(2));
        lRUCache.put(2, 6); // cache is {1=1}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(1, 5); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.put(1, 2); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}

        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(2));    // return 3
    }
}
