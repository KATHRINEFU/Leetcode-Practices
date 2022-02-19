package basics;

/**
 * @author: Kate Fu
 * @create: 2022-02-19 9:37
 */
public class PowerofTwo {
    public static void main(String[] args) {
        int n=17;
        Solution231 test = new Solution231();
        test.isPowerOfTwo(n);
    }
}
class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if(n==1) return true;
        while(n>1 && n%2==0){
            if(n==2) return true;
            n=n/2;
        }
        return false;
    }

    public boolean isPowerOfTwoSample(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}