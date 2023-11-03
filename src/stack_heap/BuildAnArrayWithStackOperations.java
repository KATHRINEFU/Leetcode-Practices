package stack_heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName BuildAnArrayWithStackOperations
 * @Description TODO
 * @Author katefu
 * @Date 11/2/23 11:18 PM
 * @Version 1.0
 **/
public class BuildAnArrayWithStackOperations {
    public static void main(String[] args) {
        int[] target = {1,3};
        Solution1441 test =  new Solution1441();
        test.buildArray(target, 3);
    }
}

class Solution1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for(int i=1; i<=n; i++){
            if(index == target.length) break;
            if(target[index]==i) {
                index++;
                res.add("Push");
                stack.push(i);
            }
            else {
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;
    }
}