package basics;

/**
 * @author: Kate Fu
 * @create: 2021-09-27 10:53
 */
public class ReverseInteger {
  public static void main(String[] args) {
      int x1 = 123;
      int x2 = -789;
      Solution s = new Solution();
      int rx1 = s.reverse(x1);
    System.out.println(rx1);
    System.out.println(s.reverse(x2));
  }
}

class Solution {
    public int reverse(int x) {
        int reverseX=0;
        String s = x+"";
        char[] c = new char[s.length()];
        if(s.charAt(0)!='-'){
            for(int i=0;i<c.length;i++){
                c[i] = s.charAt(i);
            }
            for(int i=0;i<c.length;i++){
                reverseX += (c[i]-'0')* (int)Math.pow(10,i);
            }
        }
        else{
            c[0]=s.charAt(0);
            for(int i=1;i<c.length;i++){
                c[i] = s.charAt(i);
            }
            for(int i=1;i<c.length;i++){
                reverseX += (c[i]-'0')*(int)Math.pow(10,(i-1));
            }
            reverseX = -reverseX;
        }
        if(reverseX< -(int)Math.pow(2,31) || reverseX>=(int)Math.pow(2,31)){
            return 0;
        }
        return reverseX;
    }

    //sample answer!
    public int reverse1(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    //sample answer 2
    //Time Complexity: O(log(x)). There are roughly log_10(x) digits in x.
    //Space Complexity: O(1)
    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
