package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName PathWithMaximumProbability
 * @Description
 * You are given an undirected weighted graph of n nodes (0-indexed),
 * represented by an edge list where edges[i] = [a, b] is an undirected edge connecting
 * the nodes a and b with a probability of success of traversing that edge succProb[i].
 *
 * Given two nodes start and end, find the path with the maximum probability of success
 * to go from start to end and return its success probability.
 *
 * If there is no path from start to end, return 0.
 * Your answer will be accepted if it differs from the correct answer by at most 1e-5.
 * @Author katefu
 * @Date 6/13/22 12:00 PM
 * @Version 1.0
 **/
public class PathWithMaximumProbability {
}

class Solution1514 {
    class State{
        int id;
        double prob;
        public State(int id, double prob){
            this.id = id;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double prob = succProb[i];
            graph[from].add(new double[]{(double)to, prob});
            graph[to].add(new double[]{(double)from, prob});
        }

        double[] probTo = new double[n];
        probTo[start]=1;
        Queue<State> pq = new PriorityQueue<>((a, b)->{
            return Double.compare(b.prob, a.prob);
        });

        pq.offer(new State(start, 1));

        while(!pq.isEmpty()){
            State curState = pq.poll();
            int curId = curState.id;
            double curProb = curState.prob;
            if(curId == end) return curProb;
            if(curProb<probTo[curId]) continue;
            for(double[] neighbor: graph[curId]){
                double neiId = neighbor[0];
                double neiProb = neighbor[1];
                double newProb = neiProb * curProb;
                if(newProb>probTo[(int)neiId]){
                    probTo[(int)neiId] = newProb;
                    pq.offer(new State((int)neiId, newProb));
                }
            }
        }

        return 0.0;
    }
}