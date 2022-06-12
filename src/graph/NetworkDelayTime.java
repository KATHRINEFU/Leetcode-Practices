package graph;

import java.util.*;

/**
 * @ClassName NetworkDelayTime
 * @Description You are given a network of n nodes, labeled from 1 to n.
 * You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi),
 * where ui is the source node, vi is the target node, and wi is the time it takes for a signal
 * to travel from source to target.
 *
 * We will send a signal from a given node k.
 * Return the minimum time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 * @Author katefu
 * @Date 6/12/22 6:50 PM
 * @Version 1.0
 **/
public class NetworkDelayTime {
}

class Solution {

    // time limit exceed
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[]{to, weight});
        }

        int[] distTo = dijkstra(k, graph);

        int res = 0;
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, distTo[i]);
        }
        return res;
    }

    public int[] dijkstra(int start, List<int[]>[] graph){
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start]=0;
        PriorityQueue<State> pq  = new PriorityQueue<>((a, b)->{
            return a.dist - b.dist;
        });
        pq.offer(new State(start, 0));
        while(!pq.isEmpty()){
            State curState = pq.poll();
            int curId = curState.id;
            int curDist = curState.dist;
            if(curDist>distTo[curId]) continue;
            for(int[] neighbor: graph[curId]){
                int newDist = curDist+neighbor[1];
                if(newDist<=distTo[neighbor[0]]){
                    distTo[neighbor[0]] = newDist;
                    pq.offer(new State(neighbor[0], newDist));
                }
            }
        }
        return distTo;
    }

    class State{
        int id;
        int dist;
        public State(int id, int dist){
            this.id = id;
            this.dist = dist;
        }
    }


    public int networkDelayTimeSample(int[][] times, int N, int K) {
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for(int[] time : times){
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }

        //distance, node into pq
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));

        pq.add(new int[]{0, K});

        boolean[] visited = new boolean[N+1];
        int res = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.remove();
            int curNode = cur[1];
            int curDist = cur[0];
            if(visited[curNode]) continue;
            visited[curNode] = true;
            res = curDist;
            N--;
            if(map.containsKey(curNode)){
                for(int next : map.get(curNode).keySet()){
                    pq.add(new int[]{curDist + map.get(curNode).get(next), next});
                }
            }
        }
        return N == 0 ? res : -1;

    }
}
