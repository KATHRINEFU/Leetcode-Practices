package basics;

/**
 * @author: Kate Fu
 * @create: 2022-02-14 14:04
 */
public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{0,0,0}};
        int sr=1;
        int sc=1;
        int newColor=2;

        Solution733 test = new Solution733();
        test.floodFillSample(image, sr, sc, newColor);
    }
}

class Solution733 {
    public int[][] floodFillSample(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}