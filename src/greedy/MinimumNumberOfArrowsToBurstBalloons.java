package greedy;

import java.util.Arrays;

/**
 * @ClassName MinimumNumberOfArrowsToBurstBalloons
 * @Description TODO
 * @Author katefu
 * @Date 6/28/22 11:34 AM
 * @Version 1.0
 **/
public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] points ={{1,2},{3,4},{5,6},{7,8}};
        Solution452 test = new Solution452();
        test.findMinArrowShots(points);
    }
}

class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        if(points.length==2 && points[0][1]<points[1][0]){
            return 2;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }
}
