package OA;

import java.util.*;

/**
 * @ClassName Ebay
 * @Description TODO
 * @Author katefu
 * @Date 11/4/22 4:51 PM
 * @Version 1.0
 **/
public class Ebay {
    public static void main(String[] args) {
        int[][] lamps = {{-2,1},{2,1}};
        int res = test4(lamps);
        System.out.println(res);
    }
    //find coordinate of the point that is iluminated by highest number of lamps
    //if time, return the small one

    public static int test4(int[][] lamps){
        if(lamps==null || lamps.length==0) return -1;
        int[][] ranges = new int[lamps.length][2];
        for(int i=0; i<lamps.length; i++){
            ranges[i][0] = lamps[i][0]-lamps[i][1];
            ranges[i][1] = lamps[i][0]+lamps[i][1];
        }

//        int m = Math.max(Math.abs(lamps[0][0] - lamps[0][1]), Math.abs(lamps[lamps.length-1][0]+lamps[lamps.length-1][1]);
        int m = Math.abs(lamps[0][0] - lamps[0][1]);
        int[] diff = new int[2*m+1];
        for(int[] range: ranges){
            int x1 = range[0]+m;
            diff[x1] +=1;
            int x2 = range[1] + m+1;
            if(x2<2*m+1){
                diff[x2]+=-1;
            }
        }

        int total = 0;
        ArrayList<Integer> scores = new ArrayList<>();
        for(int i=0; i<diff.length; i++){
            total+=diff[i];
            scores.add(total);
        }

        int res = 0, max = 0;
        for(int i=0; i<scores.size(); i++){
            int cur = scores.get(i);
            if(cur>max){
                max =cur;
                res = i;
            }
        }
        return res-m;

//        Queue<int[]> minHeap = new PriorityQueue<>((a, b)-> a[0] - b[0]);
//        int res = Integer.MIN_VALUE;
//        int gloMax = 0;
//        int max = 0;
//        for(int[] range : ranges) {
//            minHeap.offer(new int[] {range[0], 1});
//            minHeap.offer(new int[] {range[1], -1});
//        }
//        while(!minHeap.isEmpty()) {
//            int[] cur = minHeap.poll();
//            max += cur[1];
//            if(max > gloMax) {
//                gloMax = max;
//                res = cur[0];
//            }
//        }
//        return res;
    }

}
