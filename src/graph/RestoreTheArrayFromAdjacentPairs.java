package graph;

import java.util.*;

/**
 * @ClassName RestoreTheArrayFromAdjacentPairs
 * @Description TODO
 * @Author katefu
 * @Date 11/10/23 10:38 AM
 * @Version 1.0
 **/
public class RestoreTheArrayFromAdjacentPairs {
    public static void main(String[] args) {
        int[][] pairs = {{2,1},{3,4},{3,2}};
        Solution1743 test = new Solution1743();
        test.restoreArray(pairs);
    }
}


class Solution1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(graph, adjacentPairs);
        int start = findFirstStart(graph);
        Set<Integer> visited = new HashSet<>();
        List<Integer> resList = new ArrayList<>();
        findOriginalArray(graph, start,  resList, visited);
        int[] res = new int[resList.size()];
        for(int i = 0; i<resList.size(); i++){
            res[i] = resList.get(i);
        }
        return res;
    }

    public void findOriginalArray(Map<Integer, List<Integer>> graph, int start, List<Integer> resList, Set<Integer> visited){
        resList.add(start);
        visited.add(start);

        for(int child: graph.get(start)){
            if(!visited.contains(child)){
                findOriginalArray(graph, child, resList, visited);
            }
        }
    }

    public int findFirstStart(Map<Integer, List<Integer>> graph){
        for(Map.Entry<Integer, List<Integer>> entry: graph.entrySet()){
            if(entry.getValue().size()==1){
                return entry.getKey();
            }
        }
        return 0;
    }

    public void buildGraph(Map<Integer, List<Integer>> graph, int[][] adjacentPairs){
        for(int[] pair: adjacentPairs){
            int from = pair[0];
            int to = pair[1];
            if(!graph.containsKey(from)){
                graph.put(from, new ArrayList<>());
            }
            if(!graph.containsKey(to)){
                graph.put(to, new ArrayList<>());
            }

            List<Integer> fromList = graph.get(from);
            fromList.add(to);

            List<Integer> toList = graph.get(to);
            toList.add(from);

            graph.put(from, fromList);
            graph.put(to, toList);
        }
    }
}