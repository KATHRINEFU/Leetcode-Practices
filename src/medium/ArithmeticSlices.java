package medium;

public class ArithmeticSlices {
}

class Solution413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int slices = 0;
        for (int i = 2, prev = 0; i < nums.length; i++)
            slices += (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) ?
                    ++prev :
                    (prev = 0);
        return slices;
    }

    //1st dp
    public int numberOfArithmeticSlicesSample(int[] A) {
        int n=A.length;
        if(n<3){return 0;}
        boolean[][] dp=new boolean[n][n]; //initial value is false
        int count=0;
        for(int i=0;i<n-3+1;i++){
            if((A[i+1]-A[i])==(A[i+2]-A[i+1])){
                dp[i][i+3-1]=true;
                count++;
            }
        }
        for(int k=4;k<=n;k++){
            for (int i=0;i<n-k+1;i++){
                int j=i+k-1;
                if(dp[i+1][j]==true&&(A[i+1]-A[i]==A[i+2]-A[i+1])){
                    dp[i][j]=true;
                    count++;
                }else if(dp[i][j-1]==true&&(A[j]-A[j-1]==A[j-1]-A[j-2])){
                    dp[i][j]=true;
                    count++;
                }
            }
        }
        return count;
    }

    //2nd DP
    public int numberOfArithmeticSlicesSample2(int[] A) {
        int n=A.length;
        if(n<3){return 0;}
        int[] dp=new int[n];
        dp[0]=0;
        dp[1]=0;
        int sum=0;
        for(int i=2;i<n;i++){
            if((A[i]-A[i-1])==(A[i-1]-A[i-2])){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=0;
            }
            sum+=dp[i];
        }
        return sum;
    }
}