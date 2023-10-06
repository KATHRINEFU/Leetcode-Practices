package OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Samsara
 * @Description TODO
 * @Author katefu
 * @Date 11/6/22 4:11 PM
 * @Version 1.0
 **/
public class Samsara {
    public static void main(String[] args) {
//        int[] arr1 = {6,7,8,8,5,3,2};
//        test1(arr1);
//        for(int i : arr1) System.out.println(i);

//        String[] songs = {"notion:180", "voyage:185","sample:180"};
//        String[] animations = {"circles:360","squares:180", "lines:37"};
//        String[] res2 = test2(songs, animations);
//        for(String i: res2) System.out.println(i);

//        char[][] matrix = {{'1','+','3','-','2'},{'-','2','+','3','+'},{'1','-','4','-','4'},{'+','2','-','7','+'}
//        ,{'2','+','5','+','9'},{'+','1','+','8','-'},{'2','-','0','-','2'}};
//        int res3 = test3(matrix);
//        System.out.println(res3);

        int[][] centers = {{1,1},{2,2},{0,4}};
        int res4 = test4(centers);
        System.out.println(res4);

    }
    public static int[] test1(int[] arr){
        for(int i=0; i<arr.length; i+=2){
            if(i+1>=arr.length) continue;
            if(arr[i]>arr[i+1]){
                int temp  = arr[i];
                arr[i] =arr[i+1];
                arr[i+1] = temp;
            }
        }
        return arr;
    }

    public static String[] test2(String[] songs, String[] animations){
        int[] aLens = new int[animations.length];
        for(int i=0; i<animations.length; i++){
            aLens[i] = Integer.parseInt(animations[i].split(":")[1]);
        }

        String[] res = new String[songs.length];
        for(int i=0; i<songs.length; i++){
            int sLen = Integer.parseInt(songs[i].split(":")[1]);
            for(int j=0; j<aLens.length; j++){
                if(aLens[j]<=sLen && (sLen/aLens[j]) * aLens[j]==sLen){
                    res[i] = animations[j].split(":")[0]+":"+sLen/aLens[j];
                    break;
                }
            }
        }

        return res;
    }

    static int globalMax = 0;
    public static int test3(char[][] matrix){
        if(matrix==null || matrix.length==0) return -1;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]>='0' && matrix[i][j]<='9'){
                    goDown(matrix, i, j, 0, true, true);
                    goRight(matrix, i, j, 0, true, true);
                }
            }
        }
        return globalMax;
    }

    private static void goRight(char[][] matrix, int r, int c, int curMax, boolean isOpe, boolean isAdd) {
        if(c >=matrix[0].length) return;
        if(isOpe && matrix[r][c]<'0') return; //continuous operators
        else if(!isOpe && matrix[r][c]>='0') return; //continuous digits
        else if(!isAdd && matrix[r][c]>='0') curMax -= Character.getNumericValue(matrix[r][c]);
        else if(isAdd && matrix[r][c]>='0') curMax += Character.getNumericValue(matrix[r][c]);
        globalMax = Math.max(curMax, globalMax);
        goRight(matrix, r, c+1, curMax, matrix[r][c]<'0', matrix[r][c]=='+');
    }

    private static void goDown(char[][] matrix, int r, int c, int curMax, boolean isOpe, boolean isAdd) {
        if(r>=matrix.length) return;
        if(isOpe && matrix[r][c]<'0') return; //continuous operators
        else if(!isOpe && matrix[r][c]>='0') return; //continuous digits
        else if(!isAdd && matrix[r][c]>='0') curMax -= Character.getNumericValue(matrix[r][c]);
        else if(isAdd && matrix[r][c]>='0') curMax += Character.getNumericValue(matrix[r][c]);
        globalMax = Math.max(curMax, globalMax);
        goDown(matrix, r+1, c, curMax, matrix[r][c]<'0', matrix[r][c]=='+');
    }

    public static int test4(int[][] centers){

        int res = 0;
        for(int i=0; i<centers.length; i++){
            if(i==centers.length-1) continue;
            for(int j=i+1; j<centers.length; j++){
                if(Math.abs(centers[i][0] - centers[j][0])<=2 && Math.abs(centers[i][1] - centers[j][1])<=2){
                    res++;
                }
            }
        }

        return res;
    }

}
