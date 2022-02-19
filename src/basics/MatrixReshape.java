package basics;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author: Kate Fu
 * @create: 2022-01-30 17:11
 */
public class MatrixReshape {
}

class Solution566{
    public int[][] matrixReshapeSample(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r*c != n*m) return nums;
        int[][] res = new int[r][c];
        for (int i=0;i<r*c;i++)
            res[i/c][i%c] = nums[i/m][i%m];
        return res;
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length==0) return null;
        if(r*c!=mat.length*mat[0].length) return mat;
        int [][] res = new int[r][c];
        ArrayList<Integer> list = new ArrayList<>(mat.length*mat[0].length);
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                list.add(mat[i][j]);
            }
        }

        Iterator ite = list.iterator();
        int m=0;
        int n=0;
        while(ite.hasNext()){
            res[m][n]=(int)ite.next();
            if(n<c-1){
                n++;
            }else{
                n=0;
                m++;
            }
        }
        return res;

    }
}