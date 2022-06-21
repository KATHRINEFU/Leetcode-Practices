package dp;

import java.util.*;

/**
 * @ClassName CheapestFlightsWithinKStops
 * @Description
 * There are n cities connected by some number of flights.
 * You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that
 * there is a flight from city fromi to city toi with cost pricei.
 *
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
 * If there is no such route, return -1.
 * @Author katefu
 * @Date 6/19/22 4:23 PM
 * @Version 1.0
 **/
public class CheapestFlightsWithinKStops {
}

class Solution787 {
    // dp solution
    HashMap<Integer, List<int[]>> graph;
    int[][] memo;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 从起点 src 出发，k 步之内到达节点 s 的最小路径权重为 dp(s, k)
        graph = buildGraph(n, flights);
        memo = new int[n+1][k+2];
        for(int[] row: memo) Arrays.fill(row, -2);
        return dp(src, k+1, dst);
    }

    public int dp(int start, int k, int s){
        if(s==start) return 0;
        if(k==0) return -1;
        if(memo[s][k]!=-2) return memo[s][k];
        int res = Integer.MAX_VALUE;
        if(graph.containsKey(s)){
            for(int[] fromNode: graph.get(s)){
                int fromId = fromNode[0];
                int fromPrice = fromNode[1];
                int subProblem = dp(start, k-1, fromId);
                if(subProblem!=-1) res = Math.min(res, subProblem+fromPrice);
            }
        }

        memo[s][k] = res==Integer.MAX_VALUE?-1:res;
        return memo[s][k];
    }

    public HashMap<Integer, List<int[]>> buildGraph(int n, int[][] flights){
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] flight:flights){
            int from = flight[0], to = flight[1], price = flight[2];
            if(!graph.containsKey(to)) graph.put(to, new LinkedList<int[]>());
            graph.get(to).add(new int[]{from, price});
        }
        return graph;
    }

    //dijsktra solution
    public int findCheapestPriceSample(int n, int[][] flights, int src, int dst, int K) {
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : flights) {
            int from = edge[0];
            int to = edge[1];
            int price = edge[2];
            graph[from].add(new int[]{to, price});
        }

        // 启动 dijkstra 算法
        // 计算以 src 为起点在 k 次中转到达 dst 的最短路径
        K++;
        return dijkstra(graph, src, K, dst);
    }

    // 输入一个起点 src，计算从 src 到其他节点的最短距离
    int dijkstra(List<int[]>[] graph, int src, int k, int dst) {
        // 定义：从起点 src 到达节点 i 的最短路径权重为 distTo[i]
        int[] distTo = new int[graph.length];
        // 定义：从起点 src 到达节点 i 至少要经过 nodeNumTo[i] 个节点
        int[] nodeNumTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        Arrays.fill(nodeNumTo, Integer.MAX_VALUE);
        // base case
        distTo[src] = 0;
        nodeNumTo[src] = 0;

        // 优先级队列，costFromSrc 较小的排在前面
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.costFromSrc - b.costFromSrc;
        });
        // 从起点 src 开始进行 BFS
        pq.offer(new State(src, 0, 0));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            int costFromSrc = curState.costFromSrc;
            int curNodeNumFromSrc = curState.nodeNumFromSrc;

            if (curNodeID == dst) {
                // 找到最短路径
                return costFromSrc;
            }
            if (curNodeNumFromSrc == k) {
                // 中转次数耗尽
                continue;
            }

            // 将 curNode 的相邻节点装入队列
            for (int[] neighbor : graph[curNodeID]) {
                int nextNodeID = neighbor[0];
                int costToNextNode = costFromSrc + neighbor[1];
                // 中转次数消耗 1
                int nextNodeNumFromSrc = curNodeNumFromSrc + 1;

                // 更新 dp table
                if (distTo[nextNodeID] > costToNextNode) {
                    distTo[nextNodeID] = costToNextNode;
                    nodeNumTo[nextNodeID] = nextNodeNumFromSrc;
                }
                // 剪枝，如果中转次数更多，花费还更大，那必然不会是最短路径
                if (costToNextNode > distTo[nextNodeID]
                        && nextNodeNumFromSrc > nodeNumTo[nextNodeID]) {
                    continue;
                }

                pq.offer(new State(nextNodeID, costToNextNode, nextNodeNumFromSrc));
            }
        }
        return -1;
    }

}


class State {
    // 图节点的 id
    int id;
    // 从 src 节点到当前节点的花费
    int costFromSrc;
    // 从 src 节点到当前节点经过的节点个数
    int nodeNumFromSrc;

    State(int id, int costFromSrc, int nodeNumFromSrc) {
        this.id = id;
        this.costFromSrc = costFromSrc;
        this.nodeNumFromSrc = nodeNumFromSrc;
    }
}
