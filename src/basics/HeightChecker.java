package basics;

/**
 * @author: Kate Fu
 * @create: 2022-02-26 7:26
 */
public class HeightChecker {
    public static void main(String[] args) {
        int[] input = {5,1,2,3,4};
        Solution17 test = new Solution17();
        test.heightChecker(input);
    }
}

class Solution17 {
    public int heightChecker(int[] heights) {
        int[] heightToFreq = new int[101];

        for (int height : heights) {
            heightToFreq[height]++;
        }

        int result = 0;
        int curHeight = 0;

        for (int i = 0; i < heights.length; i++) {
            while (heightToFreq[curHeight] == 0) {
                curHeight++;
            }

            if (curHeight != heights[i]) {
                result++;
            }
            heightToFreq[curHeight]--;
        }

        return result;
    }
}

