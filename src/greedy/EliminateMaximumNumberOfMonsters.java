package greedy;

import java.util.Arrays;

/**
 * @ClassName EliminateMaximumNumberOfMonsters
 * @Description TODO
 * @Author katefu
 * @Date 11/7/23 2:24 PM
 * @Version 1.0
 **/
public class EliminateMaximumNumberOfMonsters {
    public static void main(String[] args) {
        Solution1921 test = new Solution1921();
        int[] dist = {4,2};
        int[] speed = {5,1};
        test.eliminateMaximum(dist, speed);
    }
}

class Solution1921 {

    // sort by arriving time
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] time_to_city = new double[n];

        for (int i = 0; i < n; i++) {
            time_to_city[i] = (double)dist[i] / speed[i];
        }

        Arrays.sort(time_to_city);

        for (int i = 0; i < n; i++) {
            if (time_to_city[i] <= i) {
                return i;
            }
        }

        return n;
    }

    // O(n) counting sort

    public int eliminateMaximum2(int[] dist, int[] speed) {
        int n = dist.length;
        for (int i = 0; i < n; i++) {
            dist[i] = (int) Math.ceil((double) dist[i] / speed[i]);
            speed[i] = 0;
        }
        for (int num : dist) {
            if (num >= n) continue;
            speed[num]++;
        }
        for (int i = 1; i < n; i++) {
            speed[i] += speed[i - 1];
            if (speed[i] > i) {
                return i;
            }
        }
        return n;
    }
}