package greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TaskScheduler
 * @Description TODO
 * @Author katefu
 * @Date 7/14/22 4:01 PM
 * @Version 1.0
 **/
public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        Solution621 test = new Solution621();
        test.leastInterval(tasks, 2);
    }
}

class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        if(n==0) return tasks.length;
        int m = tasks.length;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<m; i++){
            if(!map.containsKey(tasks[i])){
                map.put(tasks[i], 1);
            }else{
                map.put(tasks[i], map.get(tasks[i])+1);
            }
        }
        int res = 0;
        int intervals = 0;
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            int value = entry.getValue();
            if(intervals!=0){
                if(value>=intervals) {
                    intervals = 0;
                    value-=intervals;
                }
                else{
                    intervals -= value;
                    value = 0;
                }
            }
            res+=value;
            intervals+=(value-1)*2;
        }

        return res+intervals;
    }

    public int leastIntervalSample(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for(char task : tasks) {
            counter[task - 'A']++;
            if(max == counter[task - 'A']) {
                maxCount++;
            }
            else if(max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}