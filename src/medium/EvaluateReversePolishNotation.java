package medium;

import java.util.Stack;

/**
 * @ClassName EvaluateReversePolishNotation
 * @Description TODO
 * @Author katefu
 * @Date 4/18/22 10:33 PM
 * @Version 1.0
 **/
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        Solution150 test = new Solution150();
        System.out.println(test.evalRPN(tokens));
    }
}

class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> opes = new Stack<>();

        for(int i=0; i<tokens.length; i++){
            String s = tokens[i];
            if(!isOperater(s)){
                nums.push(Integer.parseInt(s));
            }else{
                int a = nums.pop();
                int b = nums.pop();
                if(s=="+") nums.push(a+b);
                else if(s=="-") nums.push(b-a);
                else if(s=="*") nums.push(a*b);
                else nums.push(b/a);
            }
        }

        return nums.pop();
    }

    public boolean isOperater(String s){
        if(s=="+" || s=="-" || s=="*" || s=="/") return true;
        else return false;
    }
}