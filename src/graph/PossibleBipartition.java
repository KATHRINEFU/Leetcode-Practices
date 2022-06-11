package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName PossibleBipartition
 * @Description
 * We want to split a group of n people (labeled from 1 to n) into two groups of any size.
 * Each person may dislike some other people, and they should not go into the same group.
 *
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai
 * does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
 * @Author katefu
 * @Date 6/11/22 11:07 AM
 * @Version 1.0
 **/
public class PossibleBipartition {
}

class Solution886 {
    boolean res = true;
    boolean[] visited;
    boolean[] color;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = buildGraph(n, dislikes);
        visited = new boolean[n+1];
        color = new boolean[n+1];
        for(int i=1; i<=n; i++){
            if(!visited[i]) traverse(graph, i);
        }
        return res;
    }

    public void traverse(List<Integer>[] graph, int v){
        if(!res) return;
        visited[v] = true;
        for(int neighbor: graph[v]){
            if(!visited[neighbor]){
                color[neighbor] = !color[v];
                traverse(graph, neighbor);
            }
            if(color[neighbor]==color[v]){
                res = false;
                return;
            }
        }
    }

    public List<Integer>[] buildGraph(int n, int[][] dislikes){
        List<Integer>[] graph = new LinkedList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : dislikes) {
            int v = edge[1];
            int w = edge[0];
            graph[v].add(w);
            graph[w].add(v);
        }
        return graph;
    }
}
