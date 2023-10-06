package dp;

import java.util.*;

/**
 * @ClassName FrogJump
 * @Description TODO
 * @Author katefu
 * @Date 10/1/23 11:28 AM
 * @Version 1.0
 **/
public class FrogJump {
    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        Solution403 test = new Solution403();
        test.canCross2(stones);
    }
}

class Solution403 {
    public boolean canCross(int[] stones) {
        if(stones.length ==0) return false;
        if(stones[1]!=1) return false;

        // dp[i]: possibilities of steps to get to stones[i]
        ArrayList<Integer>[] dp = new ArrayList[stones.length];

        for(int i=0; i<dp.length; i++){
            dp[i] = new ArrayList<>();
        }

        dp[0].add(0);
        dp[1].add(1);

        for(int i=2; i<dp.length; i++){
            // can be jumped from stone[i-1], stones[i-2]...
            for(int j = i-1; j>=0; j--){
                List<Integer> prevJumps = dp[j];
                for(int jump: prevJumps){
                    if(stones[j] + jump == stones[i]){
                        dp[i].add(jump);
                    }
                    if(stones[j] + (jump-1) == stones[i]){
                        dp[i].add(jump-1);
                    }
                    if(stones[j] + (jump+1) == stones[i]){
                        dp[i].add(jump+1);
                    }
                }
            }

        }

        if(dp[dp.length-1].size() == 0) return false;
        return true;
    }

    public boolean canCross2(int[] stones) {
        if(stones.length ==0) return false;
        if(stones[1]!=1) return false;

        int n= stones.length;

        // dp[i]: possibilities of stones to get to
        // dp[i]: <from, step> or <to, step>
        Map<Integer, Integer>[] dp = new HashMap[stones.length];

        for(int i=0; i<dp.length; i++){
            dp[i] = new HashMap<>();
        }

        dp[0].put(1, 1);
        dp[1].put(2, 1);
        dp[1].put(3, 2);


        for(int i=2; i<dp.length; i++){
            // can be jumped from stone[i-1], stones[i-2]...
            for(int j = i-1; j>=0; j--){
                if(dp[j].containsKey(stones[i])){
                    int prevStep = dp[j].get(stones[i]);
                    if(stones[i] + prevStep == stones[n-1] || stones[i] + prevStep - 1 == stones[n-1]|| stones[i] + prevStep + 1 == stones[n-1]){
                        return true;
                    }
                    dp[i].put(stones[i] + prevStep, prevStep);
                    dp[i].put(stones[i] + prevStep - 1, prevStep-1);
                    dp[i].put(stones[i] + prevStep + 1, prevStep+1);
                }
            }

        }

        return false;
    }

    public boolean canCrossSample(int[] stones) {

        if(stones == null || stones.length == 0 || stones[1] != 1 ||
                stones[stones.length - 1] > (stones.length * (stones.length - 1)) / 2) return false;

        // Use map to represent a mapping from the stone (not index) to the steps that can be taken from this stone.
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(stones.length);
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>() );
        }

        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = step + stone;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }
                HashSet<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0) set.add(step - 1);
                    set.add(step + 1);
                }
            }
        }

        return false;
    }
}