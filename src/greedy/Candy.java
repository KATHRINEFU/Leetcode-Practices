package greedy;

/**
 * @ClassName Candy
 * @Description TODO
 * @Author katefu
 * @Date 6/27/22 10:55 AM
 * @Version 1.0
 **/
public class Candy {
}

class Solution135 {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for(int i=1; i<ratings.length; i++){
            if(ratings[i]>ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }else{
                candies[i] = 1;
            }
        }

        for(int i = ratings.length-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                candies[i] = Math.max(candies[i],candies[i+1]+1);
            }
        }

        int res = 0;
        for(int i=0; i<candies.length; i++){
            res+=candies[i];
        }
        return res;
    }
}
