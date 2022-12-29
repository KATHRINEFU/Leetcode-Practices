package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName SingleThreadedCPU
 * @Description TODO
 * @Author katefu
 * @Date 12/29/22 3:55 PM
 * @Version 1.0
 **/
public class SingleThreadedCPU {
    public static void main(String[] args) {
        int[][] tasks = {{7,10},{7,12},{7,5},{7,4},{7,2}};
        Solution1834 test = new Solution1834();
        int[] res = test.getOrder(tasks);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }
    }
}

class Solution1834 {
    //time limit exceed! O(n^2)
    public int[] getOrder(int[][] tasks) {
        int[] res = new int[tasks.length];
        boolean[] done = new boolean[tasks.length];
        int time = 1;
        int numRemainTask = tasks.length;
        int curIndex = 0;

        //process
        while(true){ //iterate time
            if(numRemainTask == 0) break;
            int taskIndex = findShortestAvailableTask(tasks, done, time);
            if(taskIndex!=-1){
                done[taskIndex] = true;
                res[curIndex++] = taskIndex;
                numRemainTask--;
                time+=tasks[taskIndex][1];
            }else{
                time++;
            }
        }

        return res;
    }

    public int findShortestAvailableTask(int[][] tasks, boolean[] done, int time){
        int tmpIndex = -1;
        int tmpShortest = Integer.MAX_VALUE;
        for(int i=0; i<tasks.length; i++){
            if(done[i]==false && tasks[i][0]<=time){
                if(tasks[i][1]<tmpShortest){
                    tmpIndex = i;
                    tmpShortest = tasks[i][1];
                }
            }
        }
        return tmpIndex;
    }


    //priority queue
    public int[] getOrderSample(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        int[][] extTasks = new int[n][3];
        for(int i = 0; i < n; i++) {
            extTasks[i][0] = i;
            extTasks[i][1] = tasks[i][0];
            extTasks[i][2] = tasks[i][1];
        }
        Arrays.sort(extTasks, (a,b)->a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
        int time = 0;
        int ai = 0;
        int ti = 0;
        while(ai < n) {
            while(ti < n && extTasks[ti][1] <= time) {
                pq.offer(extTasks[ti++]);

            }
            if(pq.isEmpty()) {
                time = extTasks[ti][1];
                continue;
            }
            int[] bestFit = pq.poll();
            ans[ai++] = bestFit[0];
            time += bestFit[2];
        }
        return ans;
    }
}