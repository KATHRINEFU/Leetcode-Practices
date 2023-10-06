package OA;

import java.util.*;

/**
 * @ClassName Tiktok
 * @Description TODO
 * @Author katefu
 * @Date 11/2/22 9:47 AM
 * @Version 1.0
 **/
public class Tiktok {
    public static void main(String[] args) {
//        int[] ids = {2,1,3,5,4};
//        int res = exchangeCups(ids);
//        System.out.println(res);
//        int[][] tasks = {{3,6,2},{2,5,3},{5,6,2}};
//        int res = processTask(tasks);
//        System.out.println(res);
        int[] candies = {2, 1, 4, 2, 4, 1};
        int res = eatingCandies(candies);
        System.out.println(res);

    }

    public static int eatingCandies(int[] candies){
        if(candies==null || candies.length<=1) return 0;
        int n = candies.length;
        int left = 0, right = candies.length-1;
        int leftSum = 0, rightSum = 0;
        int res = 0;
        boolean leftMoved = true, rightMoved = true;
        while(left<right){
            if(leftMoved) leftSum+=candies[left];
            if(rightMoved) rightSum+=candies[right];
            if(leftSum == rightSum) {
                res  = (left+1) + (n - right);
                left++;
                right--;
                leftMoved = true;
                rightMoved = true;
            }
            else if(leftSum<rightSum){
                left++;
                leftMoved = true;
                rightMoved = false;
            }else {
                right--;
                rightMoved = true;
                leftMoved = false;
            }
        }

        return res;
    }
    public static int processTask(int[][] tasks){
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int c1 = o1[1] - o2[1];
                if(c1!=0) return c1;
                else return o1[0] - o2[0];
            }
        });

        int res = 0;
        boolean[] computer = new boolean[tasks[tasks.length-1][1]+1]; // record of all points
        for (int i=0; i<tasks.length-1; i++){
            if(tasks[i][2]<=0) continue;
            if(tasks[i][1]<tasks[i+1][0]){ //if no overlap
//                res += tasks[i][2];
                for(int j=tasks[i][1]; j>tasks[i][1]-tasks[i][2]; j--){
                    computer[j] = true;
                }
                continue;
            }
            if(tasks[i][0]<tasks[i+1][0]){ //overlap, but not include
                int overlap = tasks[i][1] - tasks[i+1][0] +1;
                for(int j = tasks[i][1]; j>tasks[i][1]-tasks[i][2]; j--){
                    computer[j] = true;
                }
                tasks[i+1][2]-=overlap;
            }
        }


        if(tasks[tasks.length-1][2]>0){
            int[] lastTask = tasks[tasks.length-1];
            int i = 0;
            for(int j = lastTask[0]; j<lastTask[1]; j++){
                if(i== lastTask[2]) break;
                if (!computer[j]){
                    computer[j] = true;
                    i++;
                }
            }
        }

        for (boolean b : computer) {
            if (b) res++;
        }
        return res;
    }
    public static int exchangeCupsOn2(int[] labels){
        if(labels==null || labels.length<=1) return 0;
        int n = labels.length;
        int res = 0;
        for(int i=0; i<n; i++){
            int min = i;
            for(int j=i; j<n; j++){
                if(labels[min]>labels[j]) min = j;
            }
            if(i!=min){
                int tmp = labels[i];
                labels[i] = labels[min];
                labels[min] = tmp;
                res++;
            }
        }
        return res;
    }

    public static int exchangeCups(int[] labels) {
        if(labels==null || labels.length<=1) return 0;
        int res = 0;
        ArrayList<Integer> oriList = new ArrayList<>();
        for(int label: labels){
            oriList.add(label);
        }
        ArrayList<Integer> targetList = new ArrayList<>();
        Arrays.sort(labels);
        for(int label: labels){
            targetList.add(label);
        }

        HashMap<Integer, Integer> valueToIndex = new HashMap<>();
        for(int i=0; i<oriList.size(); i++){
            valueToIndex.put(valueToIndex.get(i), i);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<targetList.size(); i++){
            int num = targetList.get(i);
            map.put(num, valueToIndex.get(num));
        }

        for(int i=0; i<oriList.size(); i++){
            int nextMin = targetList.get(i);
            int curNum = oriList.get(i);
            if(curNum!=nextMin){
                int nextMinIndex = map.get(nextMin);
                Collections.swap(oriList, i, nextMinIndex);
                map.put(nextMin, i);
                map.put(curNum, nextMinIndex);
                res++;
            }
        }
        return res;
    }

}
