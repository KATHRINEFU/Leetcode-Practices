package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName NonOverlappingIntervals
 * @Description TODO
 * @Author katefu
 * @Date 6/28/23 11:10 AM
 * @Version 1.0
 **/
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        Solution435 test = new Solution435();
        test.eraseOverlapIntervals(intervals);
    }
}

class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });

        int[] intervalFirst = intervals[0];

        for(int i=1; i<intervals.length; i++){
            if (firstIntervalwithinSecond(intervalFirst, intervals[i])) {
                //mark first interval to be removed
                res++;
                // determine which interval to remove
                //remove the interval that ends last
                if (intervalFirst[1] > intervals[i][1]) {
                    intervalFirst = intervals[i];
                }
            } else {
                intervalFirst = intervals[i];
            }
        }

        return res;
    }

    public boolean firstIntervalwithinSecond(int[] i1,int[] i2) {
        return i2[0] < i1[1];
    }


}
