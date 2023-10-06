package string;

import java.util.Stack;

/**
 * @ClassName DecodeString
 * @Description TODO
 * @Author katefu
 * @Date 9/28/23 1:57 PM
 * @Version 1.0
 **/
public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        Solution394 test = new Solution394();
        test.decodeStringSample(s);
    }
}

class Solution394 {
    public String decodeString(String s) {
        Stack<Integer>numStack=new Stack<>();
        Stack<StringBuilder>strBuild=new Stack<>();
        StringBuilder str = new StringBuilder();
        int num=0;
        for(char c:s.toCharArray()){
            if(c>='0' && c<='9'){
                num=num*10 +c -'0';
            }
            else if(c=='['){
                strBuild.push(str);
                str=new StringBuilder();
                numStack.push(num);
                num=0;
            }else if(c==']'){
                StringBuilder temp=str;
                str=strBuild.pop();
                int count=numStack.pop();
                while(count-->0){
                    str.append(temp);
                }
            }else{
                str.append(c);
            }
        }
        return str.toString();

    }

    private String repeat(int f, String t) {
        String d = "";

        while(f-- > 0)
            d += t;

        return d;
    }

    public boolean isNum(char s) {
        return (s >= '0' && s <= '9');
    }

    public boolean isLetter(char s) {
        return (s >= 'a' && s <= 'z');
    }

    public String decodeStringSample(String s) {

        String d = "";

        int i = 0;
        while(i < s.length()) {

            while(i < s.length() && isLetter(s.charAt(i)))
                d += s.charAt(i++);

            String f = "";
            while(i < s.length() && isNum(s.charAt(i)))
                f += s.charAt(i++);

            if (f.isEmpty())
                f += "1";

            String t = "";
            if(i < s.length() && s.charAt(i) == '[') {

                int open = 0;
                int closing = -1;

                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) == '[')
                        open++;
                    else if (s.charAt(j) == ']')
                        open--;

                    if (open == 0) {
                        closing = j;
                        break;
                    }
                }

                for (int j = i + 1; j < closing; j++)
                    t += s.charAt(j);

                i = closing + 1;
            }

            d += repeat(Integer.valueOf(f), decodeString(t));
        }
        return d;
    }
}