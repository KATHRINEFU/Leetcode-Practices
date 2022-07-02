package greedy;

import java.util.Arrays;

/**
 * @ClassName VideoStitching
 * @Description
 * You are given a series of video clips from a sporting event that lasted time seconds.
 * These video clips can be overlapping with each other and have varying lengths.
 *
 * Each video clip is described by an array clips where clips[i] = [starti, endi] indicates that
 * the ith clip started at starti and ended at endi.
 *
 * Return the minimum number of clips needed so that we can cut the clips into segments that cover the entire sporting event [0, time].
 * If the task is impossible, return -1.
 *

 * @Author katefu
 * @Date 6/30/22 10:36 AM
 * @Version 1.0
 **/
public class VideoStitching {
    public static void main(String[] args) {
        int[][] clips = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        Solution1024 test = new Solution1024();
        test.videoStitching(clips,10);
    }
}

class Solution1024 {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
//        for(int i=0; i<clips.length;i++){
//            for(int j=0; j<2; j++){
//                System.out.println(clips[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
        int curEnd = 0;
        int res = 0;
        for(int i=0; i<clips.length; ){
            if(clips[i][0]>curEnd) return -1;
            int maxEnd = curEnd;
            while (i<clips.length && clips[i][0]<=curEnd){
                maxEnd = Math.max(maxEnd, clips[i][1]);
                i++;
            }
            curEnd = maxEnd;
            res++;

            if(curEnd>=time) return res;
        }
        return -1;
    }

    public int videoStitchingSample(int[][] clips, int T) {
        int res = 0;
        Arrays.sort(clips, (a,b) ->  a[0] - b[0]);
        for (int i = 0, st = 0, end = 0; st < T; st = end, ++res) {
            for (; i < clips.length && clips[i][0] <= st; ++i)
                end = Math.max(end, clips[i][1]);
            if (st == end) return -1;
        }
        return res;
    }
}
