package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: Kate Fu
 * @create: 2022-01-29 18:21
 */
public class IntersectTwoArrays {
    public static void main(String[] args) {
        int[] n1 = {4,9,5,9};
        int[] n2 = {7,9,0,6,9};
        Solution350 test = new Solution350();
        int[] res = test.intersect(n1,n2);
        for(int i=0; i<res.length; i++){
            System.out.println(res[i]);
        }
    }
}

class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            int freq = map.getOrDefault(i, 0);
            map.put(i, freq + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : nums2){
            if(map.get(i) != null && map.get(i) > 0){
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] ret = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            ret[i] = list.get(i);
        }
        return ret;
    }

    public int[] intersectSorted(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while(i < n && j < m){
            int a = nums1[i], b= nums2[j];
            if(a == b){
                list.add(a);
                i++;
                j++;
            }else if(a < b){
                i++;
            }else{
                j++;
            }
        }
        int[] ret = new int[list.size()];
        for(int k = 0; k < list.size();k++) ret[k] = list.get(k);
        return ret;
    }
}