package medium;

/**
 * @author: Kate Fu
 * @create: 2022-02-09 18:14
 */
public class TwoSum2 {
    public static void main(String[] args) {
        int[] nums = {2,3,4};
        Solution167 test =new Solution167();
        test.twoSumSample(nums, 6);

    }
}

class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                if(numbers[i]+numbers[j]==target){
                    res[0]=i+1;
                    res[1] = j+1;
                    return res;
                }else if(numbers[i]+numbers[j]>target){
                    break;
                }
            }
        }
        return res;
    }

    public int[] twoSumSample(int[] num, int target) {
        int[] indice = new int[2];
        if (num == null || num.length < 2) return indice;
        int left = 0, right = num.length - 1;
        while (left < right) {
            int v = num[left] + num[right];
            if (v == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if (v > target) {
                right --;
            } else {
                left ++;
            }
        }
        return indice;
    }
}