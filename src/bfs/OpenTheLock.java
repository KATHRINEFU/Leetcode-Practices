package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @ClassName OpenTheLock
 * @Description TODO
 * @Author katefu
 * @Date 5/18/22 8:05 PM
 * @Version 1.0
 **/
public class OpenTheLock {
    public static void main(String[] args) {
        String[] dead = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        Solution752 test = new Solution752();
        int res = test.openLock(dead,target);
        System.out.println(res);
    }
}

class Solution752 {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>();
        for(String s : deadends){
            deadendSet.add(s);
        }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int step = 0;
        q.offer("0000");
        visited.add("0000");
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; i++){
                String cur = q.poll();
                if(deadendSet.contains(cur)) continue;
                if(cur.equals(target)) return step;
                for(int j=0; j<4; j++){
                    String up = plusOne(cur,j);
                    if(!visited.contains(up)){
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if(!visited.contains(down)){
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public String plusOne(String s, int i){
        char[] ch = s.toCharArray();
        if(ch[i]=='9') ch[i]='0';
        else ch[i]+=1;
        return  new String(ch);
    }

    public String minusOne(String s, int i){
        char[] ch = s.toCharArray();
        if(ch[i]=='0') ch[i]='9';
        else ch[i]-=1;
        return  new String(ch);
    }

    //双向BFS
    int openLockBidirectional(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        // 用集合不用队列，可以快速判断元素是否存在
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int step = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
            Set<String> temp = new HashSet<>();

            /* 将 q1 中的所有节点向周围扩散 */
            for (String cur : q1) {
                /* 判断是否到达终点 */
                if (deads.contains(cur))
                    continue;
                if (q2.contains(cur))
                    return step;

                visited.add(cur);

                /* 将一个节点的未遍历相邻节点加入集合 */
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up))
                        temp.add(up);
                    String down = minusOne(cur, j);
                    if (!visited.contains(down))
                        temp.add(down);
                }
            }
            /* 在这里增加步数 */
            step++;
            // temp 相当于 q1
            // 这里交换 q1 q2，下一轮 while 就是扩散 q2
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }
}