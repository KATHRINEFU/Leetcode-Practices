package OA;

/**
 * @ClassName FlipLetter
 * @Description TODO
 * @Author katefu
 * @Date 10/7/22 10:29 AM
 * @Version 1.0
 **/
public class FlipLetter {
    public static void main(String[] args) {
        int[][] matrix = {{2,0,0,0,2},{1,2,1,2,0},{0,1,2,1,0},{0,0,2,1,1},{1,1,2,1,1}};
        int res = test(matrix);
        System.out.println(res);
    }
    public static int test(int[][] matrix){
        int res = Integer.MAX_VALUE;
        int n = matrix.length;
        int[][] possibilities = {{0,1},{1,0},{1,2},{2,1},{0,2},{2,0}};
        for(int[] pos: possibilities){
            int steps = 0;
            int yLetter = pos[0];
            int oLetter = pos[1];
            boolean flag = true;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if((i<=n/2 && i==j) || (i<=n/2 && j==n-i-1) || (i>n/2 && j==n/2)){
                        if(matrix[i][j]!=yLetter){
                            steps++;
                            if(steps>=res) {
                                flag = false;
                                break;
                            }
                        }
                    }else{
                        if(matrix[i][j]!=oLetter){
                            steps++;
                            if(steps>=res) {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                if(!flag) break;
            }
            res =Math.min(res, steps);
        }
        return res;
    }

}
