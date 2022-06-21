package dp;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @ClassName FreedomTrail
 * @Description Given a string ring that represents the code engraved on the outer ring and another string key that
 * represents the keyword that needs to be spelled,return the minimum number of steps to spell all the characters in the keyword.
 * @Author katefu
 * @Date 6/19/22 11:32 AM
 * @Version 1.0
 **/
public class FreedomTrail {
}

class Solution514 {
    //存储ring中每个字母的索引，一个字母可能有多个索引
    HashMap<Character, LinkedList<Integer>> map = new HashMap<>();
    int[][] memo;
    public int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        memo = new int[m+1][n+1];
        //填充map
        for(int i=0; i<m;i++){
            char c = ring.charAt(i);
            if(!map.containsKey(c)) map.put(c,new LinkedList<>());
            map.get(c).add(i);
        }
        return dp(ring, 0, key, 0);
        //当圆盘指针指向 ring[i] 时，输入字符串 key[j..] 至少需要 dp(ring, i, key, j) 次操作。
    }

    public int dp(String ring, int i, String key, int j){
        if(j==key.length()) return 0;
        if(memo[i][j]!=0) return memo[i][j];
        int n = ring.length();
        int res = Integer.MAX_VALUE;
        //穷举当前字母的每个索引
        for(int index:map.get(key.charAt(j))){
            //转到该字母需要的距离
            int distance = Math.abs(i - index);
            //选择顺时针或逆时针
            distance  = Math.min(distance, n - distance);
            //还需要看下一个字母的位置，以当前字母为起始计算到剩下字母的步数
            int subProblem = dp(ring, index, key, j+1);
            //比较最小的步数，到该字母需要的+该字母到之后字母需要的+按（1）
            res = Math.min(res, subProblem+distance+1);
        }
        memo[i][j] = res;
        return memo[i][j];
    }
}