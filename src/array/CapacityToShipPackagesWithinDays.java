package array;

/**
 * @ClassName CapacityToShipPackagesWithinDays
 * @Description
 *     A conveyor belt has packages that must be shipped from one port to another within days days.
 *
 *     The ith package on the conveyor belt has a weight of weights[i].
 *     Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
 *     We may not load more weight than the maximum weight capacity of the ship.
 *
 *     Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days.
 * @Author katefu
 * @Date 5/23/22 10:25 PM
 * @Version 1.0
 **/
public class CapacityToShipPackagesWithinDays {
}

class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for(int weight : weights){
            //最大运力保证刚好一次性运完所有包裹
            right += weight;
            //包裹不能拆开运所以至少保证载重能承载任意一个包裹；
            left = Math.max(left, weight);
        }

        while(left<right){
            int capa = (right-left)/2+left;
            int day = findDays(weights,capa);
            if(day==days) right=capa;
            else if(day<days) right = capa;
            else if(day>days) left = capa+1;
        }

        return left;
    }

    public int findDays(int[] weights, int capa){
        int sum = 0;
        int res = 0;
        for(int weight : weights){
            sum += weight;
            if(sum > capa){
                res += 1;
                sum = weight;
            }
        }
        return res + 1;
    }

}
