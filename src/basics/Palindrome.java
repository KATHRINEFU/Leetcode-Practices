package basics;

/**
 * @author: Kate Fu
 * @create: 2021-09-27 20:16
 */
public class Palindrome {
    public static void main(String[] args){
        Solution1 s = new Solution1();
        int x=12321;
    System.out.println(s.isPalindrome(x));
    }
}

class Solution1 {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;

        String s = x+"";
        int length = s.length();
        for(int i = 0, j = s.length()-1; i<length/2  || j>length/2; i++, j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }

        }
        return true;
    }

    //do not need conversion to array Time: O(n), Space: O(logn)
    public boolean isPalindrome1(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }

}
