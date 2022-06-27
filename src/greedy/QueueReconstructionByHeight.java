package greedy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName QueueReconstructionByHeight
 * @Description TODO
 * @Author katefu
 * @Date 6/27/22 12:04 PM
 * @Version 1.0
 **/
public class QueueReconstructionByHeight {
}

class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        LinkedList<int[]> list = new LinkedList<>();

        for (int[] p : people) {
            list.add(p[1],p);
        }

        return list.toArray(new int[people.length][]);
    }
}