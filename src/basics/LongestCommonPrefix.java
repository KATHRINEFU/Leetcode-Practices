package basics;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: Kate Fu
 * @create: 2021-10-21 11:14
 */
public class LongestCommonPrefix {
    @Test
    public void test(){
        String[] strs = new String[]{""};
        Solution3 test = new Solution3();
        System.out.println(test.longestCommonPrefix(strs));
    }
}
class Solution3 {
    public String longestCommonPrefix(String[] strs) {
        boolean flag = true;
        boolean stop = false;
        int len=0;
        char[] c = new char[200];
        int j=0;

        if(strs == null || strs.length == 0 || (strs.length==1 && strs[0]==""))
            return "";


        while(stop==false){
            for(int i=0; i<strs.length-1; i++){
                if(strs[i].charAt(j)!=strs[i+1].charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                c[j]=strs[0].charAt(j);
                len++;
            }
            else{
                stop=true;
            }
            j++;
        }
        String result = String.valueOf(Arrays.copyOfRange(c,0,len));
        return result;
    }
}
