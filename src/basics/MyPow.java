package basics;

public class MyPow {
}

class Solution21{

    //runtime error
    public double myPow(double x, int n) {
        if(n==0) return 1;
        else if(n==1) return x;
        else if(n==-1) return 1/x;
        else if(n>1) return x*myPow(x, n-1);
        else return 1/x*myPow(x, n+1);
    }

    //avoid integer overflow
    public double myPowSample(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            return 1/x * myPowSample(1/x, -(n + 1));
        }
        return (n%2 == 0) ? myPowSample(x*x, n/2) : x*myPowSample(x*x, n/2);
    }
}