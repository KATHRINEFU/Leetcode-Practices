package graph;

import java.util.*;

/**
 * @ClassName DesignGraphWithShortestPathCalculator
 * @Description TODO
 * @Author katefu
 * @Date 11/11/23 4:29 PM
 * @Version 1.0
 **/
public class DesignGraphWithShortestPathCalculator {
    public static void main(String[] args) {
        int n = 13;
        int[][] edges = {{11,6,84715},{7,9,764823},{6,0,315591},{1,4,909432},{6,5,514907},{9,6,105610},{3,10,471042},
                {7,10,348752},{5,11,715628},{6,1,973999},{8,7,593929},{7,6,64688},{6,4,741734},{10,1,894247},
                {9,7,81181},{2,11,75418},{12,2,85431},{7,2,260306},{11,9,640614},{2,3,648804},{4,12,568023},
                {0,8,730096},{9,11,633474},{3,6,390214},{1,10,117955},{9,8,222602},{10,7,689294}};
        Graph graph = new Graph(n,edges);
        int res1 = graph.shortestPath(3,2);
        int res2 = graph.shortestPath(0,3);
        graph.addEdge(new int[]{1,3,4});
        int res3 = graph.shortestPath(0,3);
    }

}


class Graph {
    // graph: from -> list of [to, cost]
    // Map<Integer, List<int[]>> graph;
    // int[i][j]: shortest path from node i to node j
    int[][] minPaths;
    int n;

    public Graph(int n, int[][] edges) {
        // graph = new HashMap<>();
        this.n = n;
        minPaths = new int[n][n];

        // init minPaths, self to self:0, others: not connected: MAX_VALUE
        for(int[] path: minPaths){
            Arrays.fill(path, -1);
        }
        for(int i=0;i<n; i++){
            minPaths[i][i] = 0;
        }
        for(int[] edge: edges){
            addEdge(edge);
        }
    }

    public void addEdge(int[] edge) {
        int from = edge[0];
        int to = edge[1];
        int cost = edge[2];
        if(minPaths[from][to] != -1 && minPaths[from][to]<cost){
            return;
        }
        // update all nodes that [to from] to [to]
        for(int i=0; i<n; i++){
            // find nodes that [to from], except to itself
            if(minPaths[i][from]!=-1 && i!=to){
                // update i to 3
                // if i to 3 not connected
                if(minPaths[i][to] == -1){
                    minPaths[i][to] = minPaths[i][from] + cost;
                } // else already connected, choose the min one
                else{
                    minPaths[i][to] = Math.min(minPaths[i][from] + cost, minPaths[i][to]);
                }
            }
        }

        // update [from] to all nodes from [to]
        for(int i=0; i<n; i++){
            if(minPaths[to][i]!=-1){
                if(minPaths[from][i]==-1){
                    minPaths[from][i] = minPaths[to][i] +cost;
                }
                else{
                    minPaths[from][i] = Math.min(minPaths[from][i], minPaths[to][i] + cost);
                }

            }
        }

    }

    public int shortestPath(int node1, int node2) {
        return minPaths[node1][node2];
    }
}

class GraphSample {

    private List<List<int[]>> adjacencyList;

    public GraphSample(int n, int[][] edges) {
        adjacencyList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            addEdge(edge);
        }
    }

    public void addEdge(int[] edge) {
        int[] edgeArray = {edge[1], edge[2]};
        adjacencyList.get(edge[0]).add(edgeArray);
    }

    public int shortestPath(int node1, int node2) {
        return dijkstra(node1, node2);
    }

    private int dijkstra(int start, int end) {
        int n = adjacencyList.size();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        // Priority queue to efficiently retrieve the node with the minimum distance
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        priorityQueue.add(new int[]{0, start});

        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentNode = current[1], currentCost = current[0];

            // Skip if a shorter path has already been found
            if (currentCost > distances[currentNode])
                continue;

            // If found the target return the cost
            if(currentNode == end)
                return currentCost;

            // Explore neighbors and update distances
            for (int[] edge : adjacencyList.get(currentNode)) {
                int neighbor = edge[0], edgeLength = edge[1];
                int newRouteCost = edgeLength + distances[currentNode];

                // Update distance if a shorter route is found
                if (distances[neighbor] > newRouteCost) {
                    distances[neighbor] = newRouteCost;
                    priorityQueue.add(new int[]{newRouteCost, neighbor});
                }
            }
        }

        // Return the minimum distance or -1 if no path exists
        return ((distances[end] == Integer.MAX_VALUE) ? -1 : distances[end]);
    }
}

// Floyd-Warshall algorithm
class GraphSample2 {
    int[][] distance;
    int n;
    final int MAX_VALUE = 500_000_000;

    public GraphSample2(int n, int[][] edges) {
        this.n = n;
        distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = MAX_VALUE;
            }
            distance[i][i] = 0;
        }

        for (int[] edge : edges) {
            distance[edge[0]][edge[1]] = edge[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distance[i][j] = Math.min(
                            distance[i][j],
                            distance[i][k] + distance[k][j]
                    );
                }
            }
        }
    }

    public void addEdge(int[] edge) {
        if (distance[edge[0]][edge[1]] <= edge[2]) {
            return;
        }
        distance[edge[0]][edge[1]] = edge[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Math.min(
                        distance[i][j],
                        distance[i][edge[0]] + edge[2] + distance[edge[1]][j]
                );
            }
        }
    }

    public int shortestPath(int node1, int node2) {
        if (distance[node1][node2] == MAX_VALUE) {
            return -1;
        }
        return distance[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */