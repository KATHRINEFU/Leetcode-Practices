package string;

/**
 * @ClassName MultiplyStrings
 * @Description TODO
 * @Author katefu
 * @Date 7/11/22 11:40 AM
 * @Version 1.0
 **/
public class MultiplyStrings {
}

class Solution43 {
    public String multiply(String num1, String num2) {
        if(num2=="0" || num1=="0") return "0";
        int n = num1.length(), m = num2.length();
        int[] res = new int[m+n];
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                int product = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int p1 = i+j, p2 = i+j+1;
                int sum = product+res[p2];
                res[p1] += sum/10;
                res[p2] = sum%10;
            }
        }

        int i=0;
        while(i<res.length && res[i]==0){
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for(; i<res.length; i++){
            sb.append(res[i]);
        }

        return sb.length() == 0 ? "0" :sb.toString();
    }
}