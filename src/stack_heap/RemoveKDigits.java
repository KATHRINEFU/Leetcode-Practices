package stack_heap;

import java.util.Stack;

/**
 * @ClassName RemoveKDigits
 * @Description TODO
 * @Author katefu
 * @Date 10/8/23 12:03 AM
 * @Version 1.0
 **/
public class RemoveKDigits {
    public static void main(String[] args) {
        String s = "456";
        Solution402 test = new Solution402();
        test.removeKdigits(s, 1);
    }
}

class Solution402 {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k==n) return "0";
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<num.length(); i++){
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while(k>0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();

        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
