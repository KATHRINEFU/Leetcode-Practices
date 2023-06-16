package graph;

import java.util.*;

/**
 * @ClassName EvaluateDivision
 * @Description TODO
 * @Author katefu
 * @Date 6/4/23 8:53 PM
 * @Version 1.0
 **/
public class EvaluateDivision {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> e1 = new ArrayList<>();
        e1.add("a");
        e1.add("b");
        List<String> e2 = new ArrayList<>();
        e2.add("b");
        e2.add("c");
        equations.add(e1);
        equations.add(e2);
        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        List<String> q1 = new ArrayList<>();
        q1.add("a");
        q1.add("c");
        queries.add(q1);

        Solution399 test = new Solution399();
        test.calcEquation(equations, values, queries);
    }

}

class Solution399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations,values);
        double[] res = new double[queries.size()];

        for(int i=0; i<queries.size(); i++){
            List<String> query = queries.get(i);
            String A = query.get(0);
            String B = query.get(1);
            if(!graph.containsKey(A) || !graph.containsKey(B)){
                res[i] = -1.0;
                continue;
            }
            HashSet<String> visited = new HashSet<>();
            res[i] = findResult(graph, A, B, 1.0, visited);
        }

        return res;
    }

    public double findResult(Map<String, Map<String, Double>> graph, String A, String B, double value, HashSet<String> visited){
        if(A.equals(B)){
            return value;
        }
        visited.add(A);
        Map<String, Double> tos = graph.get(A);
        for(Map.Entry<String, Double> entry: tos.entrySet()){
            String to = entry.getKey();
            if(visited.contains(to)) continue;
            double v = entry.getValue();
            double res = findResult(graph, to, B, value * v, visited);
            if(res!= -1.0) return res;
        }

        return -1.0;
    }

    public Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values){
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i=0; i<equations.size(); i++){
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double v = values[i];

            if(!graph.containsKey(A)){
                graph.put(A, new HashMap<String, Double>());
            }

            if(!graph.containsKey(B)){
                graph.put(B, new HashMap<String, Double>());
            }

            graph.get(A).put(B, v);
            graph.get(B).put(A, 1/v);
        }

        return graph;
    }
}
