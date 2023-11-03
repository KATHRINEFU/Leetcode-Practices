package array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName NumberOfFlowersInFullBloom
 * @Description TODO
 * @Author katefu
 * @Date 10/11/23 3:24 PM
 * @Version 1.0
 **/
public class NumberOfFlowersInFullBloom {
}

class Solution2251 {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        // TLE, O(n^2) need O(nlogn)
        // -> no traverse each flower's bloom time
        // sort-> binary search?

        // Map<Integer, Integer> blooms  = new HashMap<>();
        // for(int i=0; i<flowers.length;i++){
        //     int start = flowers[i][0];
        //     int end = flowers[i][1];
        //     for(int j = start; j<=end; j++){
        //         blooms.put(j, blooms.getOrDefault(j, 0)+1);
        //     }
        // }
        // for(int i=0; i<people.length; i++){
        //     people[i] = blooms.getOrDefault(people[i], 0);
        // }

        // return people;

        // sweep line
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0]? a[1]-b[1] : a[0] - b[0]);
        for(int i=0; i<people.length; i++){
            queue.offer(new int[]{people[i], 1, i});
        }
        for(int[] flower: flowers){
            queue.offer(new int[]{flower[0], 0});
            queue.offer(new int[]{flower[1], 2});
        }

        int[] res = new int[people.length];
        int blooms = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[1]==0) blooms++;
            else if (cur[1]==2) blooms--;
            else{
                int personIndex = cur[2];
                res[personIndex] = blooms;
            }
        }

        return res;
    }

    // binary search
    public int[] fullBloomFlowersBinarySearch(int[][] flowers, int[] people) {
        int m = flowers.length;
        int[] starts = new int[m];
        int[] ends = new int[m];
        for(int i=0;i<m;i++)
        {
            starts[i]=flowers[i][0];
            ends[i]= flowers[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int n = people.length;
        int[] result = new int[n];

        for(int i=0;i<n;i++)
        {
            int open =0, close=0;
            if(people[i]<starts[0])
            {
                open =0;
            }
            else if(people[i]>=starts[m-1])
            {
                open = m;
            }
            else
            {
                int l =0, r=m-1;
                while(l<r)
                {
                    int mid = (l+r+1)>>1;
                    if(starts[mid]<=people[i])
                    {
                        l = mid;
                    }
                    else
                    {
                        r=mid-1;
                    }
                }
                open = l+1;
            }
            if(people[i]<=ends[0])
                close =0;
            else if(people[i]>ends[m-1])
            {
                close =m;
            }
            else
            {
                int l=0, r=m-1;
                while(l<r)
                {
                    int mid = (l+r+1)>>1;
                    if(ends[mid]<people[i])
                    {
                        l=mid;

                    }
                    else
                    {
                        r = mid-1;
                    }
                }
                close = l+1;
            }
            result[i]=open-close;
        }
        return result;
    }
}