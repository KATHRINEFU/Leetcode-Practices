package array;

import java.util.HashMap;

/**
 * @ClassName RandomPickWithBlacklist
 * @Description
 *     You are given an integer n and an array of unique integers blacklist.
 *     Design an algorithm to pick a random integer in the range [0, n - 1] that is not in blacklist.
 *     Any integer that is in the mentioned range and not in blacklist should be equally likely to be returned.
 *
 * Optimize your algorithm such that it minimizes the number of calls to the built-in random function of your language.
 * @Author katefu
 * @Date 5/24/22 7:20 PM
 * @Version 1.0
 **/
public class RandomPickWithBlacklist {
}

class Solution710 {
    int size;
    int blacklist[];
    HashMap<Integer, Integer> map;

    public Solution710(int n, int[] blacklist) {
//        this.size = n-blacklist.length;
//        this.blacklist = blacklist;
//        map = new HashMap<>();
//        int last = n-1;
//        for(int i=0; i<blacklist.length; i++){
//            map.put(last,blacklist[i]);
//            last--;
//        }
//
//        int start=0;
//        for(int i=0; i<n; i++){
//            if(!map.containsValue(i)){
//                map.put(start, i);
//                start++;
//            }
//        }

        map = new HashMap<>();
        size = n - blacklist.length;//4
        for(int item : blacklist){
            map.put(item, -1);//(2,-1)(3,-1)(5,-1)
        }
        int last = n - 1;//6
        for(int item : blacklist){
            if(item >= size){//
                continue;
            }
            while(map.containsKey(last)){//5,4
                last--;
            }
            map.put(item, last); //(2,6)(3,4)
            last--;//5,3
        }
    }

    public int pick() {
        int index = (int)(Math.random()*size);
        return map.getOrDefault(index, index);
    }


}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
