package contest;

/**
 * @ClassName GreatestLetterUpperAndLowerCase
 * @Description
 * Given a string of English letters s, return the greatest English letter which occurs as both a lowercase and uppercase letter in s.
 * The returned letter should be in uppercase. If no such letter exists, return an empty string.
 * @Author katefu
 * @Date 7/3/22 10:51 AM
 * @Version 1.0
 **/
public class GreatestLetterUpperAndLowerCase {
    public static void main(String[] args) {
        String s = "lEeTcOdE";
        Solution3 test = new Solution3();
        System.out.println(test.greatestLetter(s));
    }
}

class Solution3 {
    public String greatestLetter(String s) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            char c = arr[i];
            if(c-'a'<=26 && c-'a'>=0) lower[c-'a']=true;
            if(c-'A'<=26 && c-'A'>=0) upper[c-'A']=true;
        }

        for(int i=lower.length-1; i>=0; i--){
            if(lower[i]==true && upper[i]==true) return String.valueOf((char)('A'+i));
        }

        return "";
    }
}