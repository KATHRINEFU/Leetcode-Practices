
package basics;

/**
 * @author: Kate Fu
 * @create: 2021-12-26 10:19
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle="ll";
        Solution7 test = new Solution7();
        int res = test.strStr(haystack, needle);
        System.out.println(res);
    }
}
class Solution7 {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        if(haystack.length()==0) return -1;
        if(haystack.equals(needle)) return 0;
        int res=-1;
        boolean flag=false;
        char[] hArray = haystack.toCharArray();
        char[] nArray = needle.toCharArray();
        for(int i=0; i<hArray.length; i++){
            if(hArray[i]==nArray[0]){
                flag=true;
                for(int j=1; j<nArray.length; j++){
                    if(i+j>=hArray.length ||hArray[i+j]!=nArray[j]){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    res = i;
                    return res;
                }
            }
        }
        return res;
    }

    public int strStrSample(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}