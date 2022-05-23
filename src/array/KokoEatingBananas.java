package array;

/**
 * @ClassName KokoEatingBananas
 * @Description
 *     Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 *     The guards have gone and will come back in h hours.
 *
 *     Koko can decide her bananas-per-hour eating speed of k. Each hour,
 *     she chooses some pile of bananas and eats k bananas from that pile.
 *     If the pile has less than k bananas, she eats all of them instead and
 *     will not eat any more bananas during this hour.
 *
 *     Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 *     Return the minimum integer k such that she can eat all the bananas within h hours.
 * @Author katefu
 * @Date 5/23/22 9:14 PM
 * @Version 1.0
 **/
public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h=8;
        Solution875 test = new Solution875();
//        int res = test.minEatingSpeed(piles,h);
//        System.out.println(res);
        System.out.println(Math.ceil(11/4));
    }
}

class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMaxPile(piles);
        while(left<right){
            int speed = (right-left)/2+left;
            int hour = findHour(piles,speed);
            if(hour==h) right=hour;
            else if(hour<h) right = hour;
            else if(hour>h) left = hour+1;
        }

        return left;
    }

    public int findHour(int[] piles, int speed){
        int hour = 0;
        for (int pile : piles) {
            hour += pile / speed;
            if (pile % speed != 0)
                hour++;
        }
        return hour;
    }

    private int getMaxPile(int[] piles) {
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxPile = Math.max(pile, maxPile);
        }
        return maxPile;
    }
}