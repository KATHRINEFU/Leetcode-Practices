package bit;

import java.util.Arrays;

/**
 * @ClassName CardialitySorting
 * @Description
 * You are given an integer array arr. Sort the integers in the array in ascending order
 * by the number of 1's in their binary representation and in case of two or more integers
 * have the same number of 1's you have to sort them in ascending order.
 *
 * Return the array after sorting it.
 * @Author katefu
 * @Date 9/4/22 11:29 AM
 * @Version 1.0
 **/
public class CardialitySorting {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 33, 567, 1, 88};
        Solution1356 test = new Solution1356();
        test.sortByBits(arr);

    }

}

class Solution1356{
    public int[] sortByBits(int[] arr) {
        int n = arr.length, res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = countBitOne(arr[i])*10001 + arr[i];
        }

        Arrays.sort(res);
        for (int i = 0; i < n; i++) {
            res[i] %= 10001;
        }

        return res;
    }

    private int countBitOne(int n) {
        int res = 0;
        while (n != 0) {
            res += (n & 1);
            n >>= 1;
        }
        return res;
    }

}