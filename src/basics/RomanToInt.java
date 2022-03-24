package basics;


import org.junit.Test;

/**
 * @author: Kate Fu
 * @create: 2021-10-21 10:18
 */
public class RomanToInt {
    @Test
    public void test() {
        String s = "IV";
        Solution2 test = new Solution2();
        System.out.println(test.romanToInt(s));
  }
}
class Solution2 {
    public int romanToInt(String s) {

        char[] c = new char[s.length()];
        for(int i=0; i<s.length();i++){
            c[i]=s.charAt(i);
        }
        int result=0;

        for(int i=0; i<c.length; i++){
            if(i!=c.length-1 && getValue(c[i])<getValue(c[i+1])){
                result-=getValue(c[i]);
                continue;
            }
            result+=getValue(c[i]);
        }
        return result;
    }

    public static int getValue(char c){
        switch(c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return '1';
    }
}


