package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName MinCostToConnectAllPoints
 * @Description
 * You are given an array points representing integer coordinates of some points on a 2D-plane,
 * where points[i] = [xi, yi].
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|,
 * where |val| denotes the absolute value of val.
 *
 * Return the minimum cost to make all points connected.
 * All points are connected if there is exactly one simple path between any two points.
 * @Author katefu
 * @Date 6/11/22 4:54 PM
 * @Version 1.0
 **/
public class MinCostToConnectAllPoints {
}

class Solution1584 {
    public int minCostConnectPoints(int[][] points) {
        int res=0;
        int numOfPoint = points.length;
        List<int[]> edges = new ArrayList<>();
        int index=0;
        for(int i=0; i<numOfPoint; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j=i+1; j<numOfPoint; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int distance = Math.abs(x1-x2)+Math.abs(y1-y2);
                edges.add(new int[]{i,j, distance});
            }
        }

        Collections.sort(edges, (a, b)->{
            return a[2]-b[2];
        });

        UF uf = new UF(numOfPoint);
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if(uf.connected(u,v)) continue;
            res+=weight;
            uf.union(u,v);
        }
        return res;
    }
}
