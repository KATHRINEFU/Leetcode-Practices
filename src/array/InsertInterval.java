package array;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName InsertInterval
 * @Description
 *     You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
 *     represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
 *     You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *     Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
 *     still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * @Author katefu
 * @Date 5/12/22 11:08 AM
 * @Version 1.0
 **/
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,5}};
        int[] newInterval = {0,6};
        Solution57 test  = new Solution57();
        int[][] res = test.insert(intervals,newInterval);
        for(int i=0; i<res.length; i++){
            for(int j=0; j<2; j++){
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
}

class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            // we could mutate newInterval here also
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // add the union of intervals we got
        result.add(newInterval);

        // add all the rest
        while (i < intervals.length){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}