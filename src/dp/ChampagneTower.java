package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ChampagneTower
 * @Description TODO
 * @Author katefu
 * @Date 10/6/23 3:07 PM
 * @Version 1.0
 **/
public class ChampagneTower {
    public static void main(String[] args) {
        int poured = 25;
        int query_row = 6;
        int query_glass = 1;
        Solution799 test = new Solution799();
        test.champagneTowerLee(poured, query_row, query_glass);
    }
}

class Solution799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(query_glass>query_row) return 0.0;
        int minPour = findMinPour(query_row);
        if(poured<minPour) return 0.0;
        if(poured>=minPour+query_row) return 1.0;

        // that row is not full
        int extra = poured - (minPour-1);
        int glass = query_row;
        // extra 1, glass 2: 0.5, 0.5
        // extra 1, glass 3: 0.25, 0.5, 0.25
        // extra 2, glass 3: 0.5, 1, 0.5
        // extra 1, glass 4:
        double divident = Math.pow(2, glass);
        int div = extra * findDiv(glass, query_glass);
        return (double) div /divident;
    }

    public int findDiv(int row, int col){
        int[][] triangle = new int[row+1][];
        for(int i=0; i<triangle.length; i++){
            triangle[i] = new int[i+1];
            for(int j = 0; j<triangle[i].length; j++){
                if(i==0 || j==0 || i==j) triangle[i][j] = 1;
                else triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
        }
        return triangle[row][col];
    }


    public int findMinPour(int x){
        // 1-> 1(+1), 2-> 3(+1), 3->6(+1)
        int res = 0;
        for(int i=1; i<=x; i++){
            res = res+i;
        }
        return res+1;
    }

    public double champagneTowerSample(int poured, int query_row, int query_glass) {
        if(poured == 0) return 0;
        List<Double> prevRow = new ArrayList<>(List.of((double) poured));
        while(query_row -- >0){
            double champagneInEnds = Math.max(0, (prevRow.get(0)-1)/2);
            List<Double> currRow = new ArrayList<>();
            currRow.add(champagneInEnds); // first glass
            for(int i=1; i<prevRow.size(); i++){
                currRow.add(Math.max(0, (prevRow.get(i-1)-1)/2) + Math.max(0, (prevRow.get(i)-1)/2));
            }
            currRow.add(champagneInEnds); // last glass
            prevRow = currRow;
        }
        return Math.min(1, prevRow.get(query_glass));
    }

    public double champagneTowerLee(int poured, int query_row, int query_glass) {
        double[] res = new double[query_row + 2];
        res[0] = poured;
        for (int row = 1; row <= query_row; row++)
            for (int i = row; i >= 0; i--)
                res[i + 1] += res[i] = Math.max(0.0, (res[i] - 1) / 2);
        return Math.min(res[query_glass], 1.0);
    }
}