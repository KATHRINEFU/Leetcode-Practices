package graph;

import java.util.*;

/**
 * @ClassName RedundantConnection
 * @Description TODO
 * @Author katefu
 * @Date 10/3/23 10:02 PM
 * @Version 1.0
 **/
public class RedundantConnection {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        Solution684 test = new Solution684();
        int[] res = test.findRedundantConnectionSampleDFS(edges);
        System.out.println(res);
    }
}

class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<String, Integer> edgeIndex = new HashMap<>();


        for(int i=0; i<edges.length; i++){
            if(!graph.containsKey(edges[i][0])){
                graph.put(edges[i][0], new HashSet<>());
            }
            if(!graph.containsKey(edges[i][1])){
                graph.put(edges[i][1], new HashSet<>());
            }
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);

            edgeIndex.put(String.valueOf(edges[i][0]) + String.valueOf(edges[i][1]), i);
            edgeIndex.put(String.valueOf(edges[i][1]) + String.valueOf(edges[i][0]), i);
        }

        // find cycle, remove one edge
        List<Integer> cycle = new ArrayList<>();
        dfs(graph, cycle, edges[0][0], -1);

        String maxString = "";
        int maxIndex = 0;
        for(int i=0; i<cycle.size()-1; i++){
            String edgeString1 = String.valueOf(cycle.get(i)) + String.valueOf(cycle.get(i+1));

            if(edgeIndex.get(edgeString1)>maxIndex){
                maxString = edgeString1;
                maxIndex = edgeIndex.get(edgeString1);
            }

            String edgeString2 = String.valueOf(cycle.get(i+1)) + String.valueOf(cycle.get(i));

            if(edgeIndex.get(edgeString2)>maxIndex){
                maxString = edgeString2;
                maxIndex = edgeIndex.get(edgeString2);
            }
        }

        String edgeString2 = String.valueOf(cycle.get(0)) + String.valueOf(cycle.get(cycle.size()-1));

        if(edgeIndex.get(edgeString2)>maxIndex){
            maxString = edgeString2;
        }

        int v1 = maxString.charAt(0)-'0';
        int v2 = maxString.charAt(1)-'0';

        return new int[]{v1, v2};
    }

    public boolean dfs(Map<Integer, Set<Integer>> graph, List<Integer> onPath,  int start, int from){
        if(onPath.contains(start)){
            return true;
        }

        onPath.add(start);
        for(int node: graph.get(start)){
            if(node!=from)
                if(dfs(graph, onPath, node, start)) return true;
        }
        onPath.remove(onPath.size()-1);
        return false;
    }

    boolean[] visited;
    public int[] findRedundantConnectionSampleDFS(int[][] edges) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < edges.length; i++){
            hashMap.put(i + 1, new ArrayList<>());
        }

        int[] res = new int[2];
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            visited = new boolean[edges.length + 1];
            if(!hashMap.get(edge[0]).isEmpty() && !hashMap.get(edge[1]).isEmpty() && dfs(edge[0], edge[1], hashMap)){
                return edge;
            }
            hashMap.get(edge[0]).add(edge[1]);
            hashMap.get(edge[1]).add(edge[0]);
        }
        return res;
    }

    public boolean dfs(int src, int target, HashMap<Integer, List<Integer>> hashMap){
        if(src == target){
            return true;
        }
        visited[src] = true;
        List<Integer> edgeList = hashMap.get(src);

        for(Integer next: edgeList){
            if(!visited[next]){
                if(dfs(next, target, hashMap)){
                    return true;
                }
            }
        }

        return false;
    }
}
