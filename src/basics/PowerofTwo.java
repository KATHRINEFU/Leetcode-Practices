package basics;

import java.util.*;

/**
 * @author: Kate Fu
 * @create: 2022-02-19 9:37
 */
public class PowerofTwo {
    public static void main(String[] args) {
        int n=17;
        Solution231 test = new Solution231();
        test.isPowerOfTwo(n);
    }
}
class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if(n==1) return true;
        while(n>1 && n%2==0){
            if(n==2) return true;
            n=n/2;
        }
        return false;
    }

    public boolean isPowerOfTwoSample(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

    public static void sortByValue() {
        Map<String,String> map = new TreeMap<String,String>();
        map.put("a", "dddd");
        map.put("d", "aaaa");
        map.put("b", "cccc");
        map.put("c", "bbbb");

        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());

        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, String> e: list) {
            System.out.println(e.getKey()+":"+e.getValue());
        }
    }

}