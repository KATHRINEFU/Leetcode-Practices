package stack;

import java.util.Stack;

/**
 * @ClassName RemoveDuplicateLetters
 * @Description Given a string s, remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * @Author katefu
 * @Date 5/25/22 11:06 AM
 * @Version 1.0
 **/
public class RemoveDuplicateLetters {
}

class Solution316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[256];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)]++;
        }
        boolean[] inStack = new boolean[256];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            count[c]--;
            if(inStack[c]) continue;
            while(!stack.isEmpty() && c<=stack.peek()){
                if(count[stack.peek()]==0) break;
                inStack[stack.peek()]=false;
                stack.pop();
            }
            stack.push(c);
            inStack[c]=true;

        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}