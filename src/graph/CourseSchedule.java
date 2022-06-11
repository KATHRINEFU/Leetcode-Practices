package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName CourseSchedule
 * @Description TODO
 * @Author katefu
 * @Date 6/9/22 11:48 AM
 * @Version 1.0
 **/
public class CourseSchedule {
}

class Solution207 {
    boolean[] onPath;
    boolean[] visited;
    boolean hasCycle = false;

    //DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        return !hasCycle;
    }

    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] list = new LinkedList[numCourses];
        for(int i=0; i<numCourses; i++){
            list[i] = new LinkedList<>();
        }
        for(int[] row: prerequisites){
            int pre = row[0], after = row[1];
            list[after].add(pre);
        }
        return list;
    }

    public void traverse(List<Integer>[] graph, int s){
        if(onPath[s]){
            hasCycle = true;
            return;
        }
        if(visited[s]) return;
        visited[s]=true;
        onPath[s]=true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        onPath[s] = false;
    }

    // BFS Topological sort
    public boolean canFinishSample(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int[] pair:prerequisites){
            indegree[pair[1]]++;
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int select = 0;
        while(!queue.isEmpty()){
            numCourses--;
            int course = queue.poll();
            for(int[] pair:prerequisites){
                if(pair[0]==course){
                    indegree[pair[1]]--;
                    if(indegree[pair[1]]==0){
                        queue.add(pair[1]);
                    }
                }
            }
        }
        return numCourses==0;
    }
}