package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PartitionLabels
 * @Description TODO
 * @Author katefu
 * @Date 6/29/22 10:52 AM
 * @Version 1.0
 **/
public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        Solution763 test = new Solution763();
        test.partitionLabels(s);
    }
}

class Solution763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int[] lastIndex = new int[26];
        for (int i = s.length() - 1; i >= 0; i--) {
            if (lastIndex[s.charAt(i) - 'a'] == 0) {
                lastIndex[s.charAt(i) - 'a'] = i;
            }
        }
        int index=0;
        int last=-1;
        for(int i=0; i<s.length(); i++){
            index = Math.max(index, lastIndex[s.charAt(i)-'a']);
            if(i==index){
                list.add(i-last);
                last=i;
            }
        }
        return list;
    }
}
