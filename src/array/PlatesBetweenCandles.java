package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @ClassName PlatesBetweenCandles
 * @Description
 * There is a long table with a line of plates and candles arranged on top of it.
 * You are given a 0-indexed string s consisting of characters '*' and '|' only,
 * where a '*' represents a plate and a '|' represents a candle.
 *
 * You are also given a 0-indexed 2D integer array queries where queries[i] = [lefti, righti] denotes
 * the substring s[lefti...righti] (inclusive). For each query, you need to find the number of plates between candles
 * that are in the substring. A plate is considered between candles if there is at least one candle to its left and
 * at least one candle to its right in the substring.
 * @Author katefu
 * @Date 7/28/22 11:16 AM
 * @Version 1.0
 **/
public class PlatesBetweenCandles {
    public static void main(String[] args) {
        String s = "***|**|*****|**||**|*";
        int[][] queries = {{1,17},{4,5},{14,17},{5,11},{16,16}};
        Solution2055 test = new Solution2055();
        test.platesBetweenCandles(s, queries);
    }
}

class Solution2055 {
    //time limit exceed
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = queries.length;
        List<Integer> list = new ArrayList<>();
        int[] res = new int[n];
        for(int[] query: queries){
            int left = query[0];
            int right = query[1];
            String substring = s.substring(left, right+1);
            int tmpLeft = left;
            int tmpRight = right;
            while(tmpLeft<tmpRight){
                if(s.charAt(tmpLeft)=='|' && s.charAt(tmpRight)=='|') break;
                if(s.charAt(tmpLeft)!='|') tmpLeft++;
                if(s.charAt(tmpRight)!='|') tmpRight--;
            }
            if(tmpLeft>=tmpRight){
                list.add(0);
                continue;
            }else{
                int count = 0;
                while(tmpLeft<tmpRight){
                    if(s.charAt(tmpLeft)=='*') count++;
                    tmpLeft++;
                }
                list.add(count);
            }
        }

        for(int i=0; i<n; i++){
            res[i] = list.get(i);
        }

        return res;
    }

    public int[] platesBetweenCandlesSample(String s, int[][] queries) {
        int psum[] = new int[s.length() + 1];
        int next[] = new int[s.length() + 1], prev[] = new int[s.length() + 1];
        Arrays.fill(next, Integer.MAX_VALUE);
        int res[] = new int[queries.length];
        for (int i = 0; i < s.length(); ++i) {
            psum[i + 1] = psum[i] + (s.charAt(i) == '|' ? 1 : 0);
            prev[i + 1] = s.charAt(i) == '|' ? i : prev[i];
        }
        for (int i = s.length() - 1; i >= 0; --i)
            next[i] = s.charAt(i) == '|' ? i : next[i + 1];
        for (int j = 0; j < queries.length; ++j) {
            int l = next[queries[j][0]], r = prev[queries[j][1] + 1];
            res[j] = l < r ? r - l - (psum[r] - psum[l]) : 0;
        }
        return res;
    }

    //tree set+ prefix sum
    public int[] platesBetweenCandlesSample2(String s, int[][] queries) {
        int len = s.length();
        int[]left= new int[len];//plates
        TreeSet<Integer> candles = new TreeSet<>();
        int leftPlateCount = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='|')
            {
                candles.add(i);
                left[i] = leftPlateCount;
            }else{
                leftPlateCount++;
            }
        }
        int[] result = new int[queries.length];
        int i=0;
        for(int query[] : queries){
            Integer leftMostCandle = candles.ceiling(query[0]);
            Integer rightMostCandle = candles.floor(query[1]);
            if(leftMostCandle!=null && rightMostCandle!=null && leftMostCandle<rightMostCandle)
                result[i] = left[rightMostCandle]-left[leftMostCandle];

            i++;
        }
        return result;
    }
}