package graph;

/**
 * @ClassName UF
 * @Description Union find
 * @Author katefu
 * @Date 6/10/22 9:55 AM
 * @Version 1.0
 **/
public class UF {
    // 连通分量个数
    private int count;
    // 存储每个节点的父节点
    private int[] parent;

    // n 为图中节点的个数
    public UF(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // 将节点 p 和节点 q 连通
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ)
            return;

        parent[rootQ] = rootP;
        // 两个连通分量合并成一个连通分量
        count--;
    }

    // 判断节点 p 和节点 q 是否连通
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // 这段迭代代码方便你理解递归代码所做的事情
//    public int find(int x) {
//        // 先找到根节点
//        int root = x;
//        while (parent[root] != root) {
//            root = parent[root];
//        }
//        // 然后把 x 到根节点之间的所有节点直接接到根节点下面
//        int old_parent = parent[x];
//        while (x != root) {
//            parent[x] = root;
//            x = old_parent;
//            old_parent = parent[old_parent];
//        }
//        return root;
//    }

    // 返回图中的连通分量个数
    public int count() {
        return count;
    }
}

