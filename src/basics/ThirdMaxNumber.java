package basics;

/**
 * @author: Kate Fu
 * @create: 2022-02-26 8:33
 */
public class ThirdMaxNumber {
    public static void main(String[] args) {
        int[] input = {2,2,3,1};
        Solution18 test = new Solution18();
        test.thirdMax(input);
    }
}
class Solution18 {
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
}