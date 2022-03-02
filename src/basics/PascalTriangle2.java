package basics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kate Fu
 * @create: 2022-02-27 20:38
 */
public class PascalTriangle2 {
    public static void main(String[] args) {
        int n=3;
        Solution20 test = new Solution20();
        test.getRow(n);
    }
}

class Solution20 {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<>();
        if(rowIndex < 0) return res;
        helper(rowIndex, res);
        return res;
    }
    public void helper(int rowIndex, List<Integer> res){
        if(rowIndex == 0) {
            res.add(1);
            return;
        }

        helper(rowIndex - 1, res);

        for(int j = rowIndex - 1; j >=1   ; j--){
            int t1 = res.get(j);
            int t2 = res.get(j-1);
            res.set(j, t1 + t2);
        }
        res.add(1);
    }

}