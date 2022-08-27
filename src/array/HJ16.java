package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ClassName HJ16
 * @Description TODO
 * @Author katefu
 * @Date 7/31/22 4:41 PM
 * @Version 1.0
 **/
public class HJ16 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        String[] temp = line1.split(" ");
        int N = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        int[][] goods = new int[m][3];

        for(int i=0; i<m;i++){
            String line = br.readLine();
            String[] lineArr = line.split(" ");
            goods[i][0] = Integer.parseInt(lineArr[0]);
            goods[i][1] = Integer.parseInt(lineArr[1]);
            goods[i][2] = Integer.parseInt(lineArr[2]);
        }

        int[][] dp = new int[m+1][N/10+1];
        for(int i=1; i<=m; i++){
            for(int w=1; w<N; w++){
                if(w-goods[i][0]/10<0) dp[i][w] = dp[i-1][w];
                else{
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w - goods[i][0]/10]+goods[i][1]*goods[i][0]);
                }
            }
        }
        System.out.println(dp[m][N/10]);
    }
}
