package basics;

import java.util.Stack;

/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors.
'#' means a backspace character.
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        Solution844 test =  new Solution844();
        test.backspaceCompareSample(s,t);
    }
}

class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        return compute(S).equals(compute(T));
    }

    private Stack<Character> compute(String S) {
        Stack<Character> stack = new Stack();
        for (char c : S.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return stack;
    }
    // two pointer solution
    public boolean backspaceCompareSample(String S, String T) {
        int i = S.length()-1;
        int j = T.length()-1;
        int countS = 0;
        int countT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (countS > 0 || S.charAt(i) == '#')) {
                if (S.charAt(i) == '#') countS++;
                else countS--;
                i--;
            }
            char left = i < 0 ? '@' : S.charAt(i);
            while (j >= 0 && (countT > 0 || T.charAt(j) == '#')) {
                if (T.charAt(j) == '#') countT++;
                else countT--;
                j--;
            }
            char right = j < 0 ? '@' : T.charAt(j);
            if (left != right) return false;
            i--;
            j--;
        }
        return true;
    }
}
