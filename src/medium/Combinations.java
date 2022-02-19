package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kate Fu
 * @create: 2022-02-17 19:30
 */
public class Combinations {
    public static void main(String[] args) {
        int n=4;
        int k=2;
        Solution77 test = new Solution77();
        test.combine(n,k);
    }
}

class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        combine(out, in, 1, n, k);
        return out;
    }

    public void combine(List<List<Integer>> out, List<Integer> in, int start, int end, int num){
        if(num==0){
            out.add(new ArrayList<>(in));
            System.out.println(out);
            return;
        }

        for(int i=start; i<=end-num+1; i++){
            in.add(i);
            combine(out, in, i+1, end, num-1);
            in.remove(in.size()-1);
        }
    }

}