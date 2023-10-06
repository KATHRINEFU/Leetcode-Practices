package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName OnlineElection
 * @Description TODO
 * @Author katefu
 * @Date 6/27/23 9:38 PM
 * @Version 1.0
 **/
public class OnlineElection {
    public static void main(String[] args) {
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};
        int i = Arrays.binarySearch(times, 12);
        System.out.println(i);
        TopVotedCandidate t = new TopVotedCandidate(persons, times);
        t.q(25);
    }
}

class TopVotedCandidate {
    int[] times;
    Map<Integer, Integer> m = new TreeMap<>(); //times[i], lead

    public TopVotedCandidate(int[] persons, int[] times) {
        int n = persons.length, lead = -1;
        Map<Integer, Integer> count = new HashMap<>();
        this.times = times;

        for (int i = 0; i < n; ++i) {
            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
            if (i == 0 || count.get(persons[i]) >= count.get(lead)) lead = persons[i];
            m.put(times[i], lead);
        }

    }

    public int q(int t) {
        int res = 0;
        for(Map.Entry<Integer, Integer> entry : m.entrySet()){
            if(entry.getKey()<=t){
                res = entry.getValue();
            }
        }

        return res;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
