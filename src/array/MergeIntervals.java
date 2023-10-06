package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName MergeIntervals
 * @Description
 *     Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 *     and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * @Author katefu
 * @Date 5/11/22 11:38 AM
 * @Version 1.0
 **/
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        Solution56 test = new Solution56();
        int[][] res = test.merge0625(intervals);
        for(int i=0; i<res.length; i++){
            for(int j=0; j<2; j++){
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
}

class Solution56 {

    public int[][] merge0625(int[][] intervals) {

        // sort by start asc, end asc
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[0]==arr2[0]) return arr1[1] - arr2[1];
                else return arr1[0] - arr2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        int curStart = intervals[0][0];
        int curEnd = intervals[0][1];
        for(int[] interval: intervals){
            int start = interval[0];
            int end = interval[1];
            if(start>= curStart && end <= curEnd) continue;
            else if(start>=curStart && start<= curEnd && end> curEnd){
                curEnd = end;
            }
            else if(start> curEnd){
                list.add(new int[]{curStart, curEnd});
                curStart = start;
                curEnd = end;
            }
        }
        list.add(new int[]{curStart, curEnd});
        int[][] res = new int[list.size()][2];
        for(int i=0; i<res.length; i++){
            res[i] = list.get(i);
        }

        return res;
    }
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        int[][] sorted = sortByFirst(intervals);

//        for(int i=0; i<sorted.length; i++){
//            for(int j=0; j<2; j++){
//                System.out.print(sorted[i][j]);
//            }
//            System.out.println();
//        }

        int[] temp = new int[2];
        for(int i=0; i<sorted.length; i++){
            temp = sorted[i];

            for(int j=i+1; j<sorted.length; j++){
                if(sorted[j][0]>temp[1]){
                    i=j-1;
                    break;
                }
                temp[1] = Math.max(temp[1],sorted[j][1]);
                i++;
            }

            res.add(temp);
        }

        int[][] resArr = new int[res.size()][2];
        for(int i=0; i<res.size(); i++){
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    public int[][] sortByFirst(int[][] a){
        int i, j;
        int n = a.length;

        for(i=0; i<n; i++){//表示n次排序过程。
            for(j=1; j<n-i; j++){
                if(a[j-1][0] > a[j][0]){//前面的数字大于后面的数字就交换
                    //交换a[j-1]和a[j]
                    int[] temp;
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j]=temp;
                }
            }
        }

        return a;
    }

    public int[][] mergeSample(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
//            for(int i=0;i<result.size(); i++){
//                for(int j=0; j<2; j++){
//                    System.out.print(result.get(i)[j]);
//                }
//                System.out.println();
//            }
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
